package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.models.GameState;
import org.usfirst.frc.team319.models.GameState.Side;
import org.usfirst.frc.team319.models.SrxTrajectory;
import org.usfirst.frc.team319.paths.CenterSwitch;
import org.usfirst.frc.team319.paths.OppositeSideScale;
import org.usfirst.frc.team319.paths.SameSideScale;
import org.usfirst.frc.team319.paths.SameSideSwitch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutoRoutines {
	
	// AutoType Order must match paths order below.
	public enum AutoType {
		CENTER_SWITCH(Height.SWITCH, 0, null),
		SAME_SIDE_SWITCH(Height.SWITCH, 0, null),
		SAME_SIDE_SCALE(Height.SWITCH, 2, new SameSideScalePhase2()),
		OPPOSITE_SIDE_SCALE(Height.SWITCH, 6, null),
		BASELINE(Height.GROUND, 0, null);
		
		private Height height;
		private double delay;
		private Command phase2;
		
		private AutoType(Height height,  double delay, Command phase2) {
			this.height = height;
			this.delay = delay;
			this.phase2 = phase2;
		}
		
		public Height getHeight() {
			return height;
		}
		
		public double getDelay() {
			return delay;
		}
		
		public Command getPhase2() {
			return phase2;
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
	public static AutoGroup getAutoRoutine () {
		GameState state = new GameState(DriverStation.getInstance().getGameSpecificMessage());
		Side robotSide = getRobotSide(state);
		AutoType selectedAutoType = getAutoType(getSelectedAutoMode(), state, robotSide);
		HelixEvents.addEvent("ROBOT", "Selected Auto Mode: " + selectedAutoType.name() + ", flipped: " + (robotSide == Side.RIGHT));
		return new AutoGroup(
				getPath(selectedAutoType, robotSide == Side.RIGHT), 
				selectedAutoType.getHeight(),
				selectedAutoType.getDelay(),
				selectedAutoType.getPhase2());
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
				if (state.mySwitchSide == robotSide) {
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
				if (state.mySwitchSide == robotSide) {
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
				return new SameSideScale(flipped);
			case SAME_SIDE_SWITCH:
				return new SameSideSwitch(flipped);
			default:
				break;
		}
		return null;
	}
}