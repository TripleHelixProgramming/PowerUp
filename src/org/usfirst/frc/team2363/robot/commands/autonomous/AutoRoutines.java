package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.models.GameState;
import org.usfirst.frc.team319.models.GameState.Side;
import org.usfirst.frc.team319.models.SrxTrajectory;
import org.usfirst.frc.team319.paths.Baseline;
import org.usfirst.frc.team319.paths.CenterSwitch;
import org.usfirst.frc.team319.paths.OppositeSideScale;
import org.usfirst.frc.team319.paths.SameSideScale;
import org.usfirst.frc.team319.paths.SameSideSwitch;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutoRoutines {
	
	// AutoType Order must match paths order below.
	public enum AutoType {
		CENTER_SWITCH(Height.SWITCH, 0),
		SAME_SIDE_SWITCH(Height.SWITCH, 3),
		SAME_SIDE_SCALE(Height.SCALE, 2.5),
		SCALE_TO_SWITCH(Height.SCALE, 2.5),
		OPPOSITE_SIDE_SCALE(Height.SCALE, 6),
		BASELINE(Height.GROUND, 0);
		
		private Height height;
		private double delay;
		
		private AutoType(Height height,  double delay) {
			this.height = height;
			this.delay = delay;
		}
		
		public Height getHeight() {
			return height;
		}
		
		public double getDelay() {
			return delay;
		}
	}
	
	enum AutoMode {
		CENTER_SWITCH,
		OUR_SIDE_ONLY,
		SWITCH_SCALE_SCALE,
		SCALE_ONLY;
	}
	
    private static DigitalInput left = new DigitalInput(0);
    private static DigitalInput right = new DigitalInput(1);
    private static DigitalInput centerSwitch = new DigitalInput(2);
    private static DigitalInput ourSideOnly = new DigitalInput(3);
    private static DigitalInput switchScaleScale = new DigitalInput(4);
    private static DigitalInput scaleOnly = new DigitalInput(5);  // default
	
	
	/* 
	 * Base on Robot Position on the alliance wall & plates states, determines 
	 * which auto routine to run, gripper height, and whether left & right motion
	 * profiles need to be reverse base on field symmetry.
	 * 
	 */
	public static Command getAutoRoutine () {
		GameState state = new GameState(DriverStation.getInstance().getGameSpecificMessage());
		Side robotSide = getRobotSide(state);
		AutoType selectedAutoType = getAutoType(getSelectedAutoMode(), state, robotSide);
		boolean flipped = robotSide == Side.RIGHT;
		HelixEvents.addEvent("ROBOT", "Selected Auto Mode: " + selectedAutoType.name() + ", flipped: " + flipped);
		if (selectedAutoType == AutoType.BASELINE) {
			return new FollowTrajectory(getPath(selectedAutoType, flipped));
		}
		
		return new AutoGroup(
				getPath(selectedAutoType, flipped), 
				selectedAutoType.getHeight(),
				selectedAutoType.getDelay(),
				getPhase2(selectedAutoType, flipped));
	}
	
	private static Side getRobotSide(GameState state) {
		if (centerSwitch.get()) {
			return state.mySwitchSide; 
		} else {
			if (left.get()) {
				return Side.LEFT;
			} else {
				return Side.RIGHT;
			} 
		}
	}
	
	private static AutoMode getSelectedAutoMode() {
		if (centerSwitch.get()) {
			return AutoMode.CENTER_SWITCH;
		} else if (ourSideOnly.get()) {  // Our Side only auto
			return AutoMode.OUR_SIDE_ONLY;
		} else if (switchScaleScale.get()) { 
			return AutoMode.SWITCH_SCALE_SCALE;
		} else {  // ScaleOnly run
			return AutoMode.SCALE_ONLY;
		}
	}
	
	static AutoType getAutoType(AutoMode selectedAutoMode, GameState state, Side robotSide) {
		switch (selectedAutoMode) {
			case CENTER_SWITCH:
				return AutoType.CENTER_SWITCH;
			case OUR_SIDE_ONLY:
				if (state.mySwitchSide == robotSide && state.scaleSide == robotSide) {
					return AutoType.SCALE_TO_SWITCH;
				} else if (state.mySwitchSide == robotSide) {
					// Switch is on our side. Go for the switch first over the scale.
					return AutoType.SAME_SIDE_SWITCH;
				} else if (state.scaleSide == robotSide) {
					// Switch is not on our side, but scale is.
					return AutoType.SAME_SIDE_SCALE;
				} else {  
					// Neither the Switch nor the Scale are on our side.
					return AutoType.BASELINE;
				}
			case SWITCH_SCALE_SCALE:
				if (state.mySwitchSide == robotSide && state.scaleSide == robotSide) {
					return AutoType.SCALE_TO_SWITCH;
				} else if (state.mySwitchSide == robotSide) {
					// Switch is on our side. Go for the switch first over the scale.
					return AutoType.SAME_SIDE_SWITCH;
				} else if (state.scaleSide == robotSide){
					// Switch is not on our side, but scale is. Go for scale.
					return AutoType.SAME_SIDE_SCALE;
				} else { 
					// Neither the Switch nor the Scale are on our side. Go for opposite side scale. 
					return AutoType.OPPOSITE_SIDE_SCALE;
				}
			default:
				if (state.scaleSide == robotSide) {
					return AutoType.SAME_SIDE_SCALE;
				} else {
					return AutoType.OPPOSITE_SIDE_SCALE;
				}
		}
	}
	
	private static SrxTrajectory getPath(AutoType autoType, boolean flipped) {
		switch (autoType) {
			case CENTER_SWITCH:
				return new CenterSwitch();
			case OPPOSITE_SIDE_SCALE:
				return new OppositeSideScale(flipped);
			case SAME_SIDE_SCALE:
			case SCALE_TO_SWITCH:
				return new SameSideScale(flipped);
			case SAME_SIDE_SWITCH:
				return new SameSideSwitch(flipped);
			default:
				return new Baseline(flipped);
		}
	}
	
	private static Command getPhase2(AutoType autoType, boolean flipped) {
		switch (autoType) {
			case OPPOSITE_SIDE_SCALE:
				return new OppositeSideScalePhase2(flipped);
			case SAME_SIDE_SCALE:
				return new SameSideScalePhase2(flipped);
			case SAME_SIDE_SWITCH:
				return new SameSideSwitchPhase2(flipped);
			case SCALE_TO_SWITCH:
				return new ScaleToSwitchPhase2(flipped);
			default:
				return null;
		}
	}
}