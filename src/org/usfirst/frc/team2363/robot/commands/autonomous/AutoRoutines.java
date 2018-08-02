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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoRoutines {
	
	// AutoType Order must match paths order below.
	public enum AutoType {
		CENTER_SWITCH(Height.SWITCH, 1.5),
		SAME_SIDE_SWITCH(Height.SWITCH, 3),
		SAME_SIDE_SCALE(Height.SCALE, 2.5),
		SCALE_TO_SWITCH(Height.SCALE, 2.5),
		OPPOSITE_SIDE_SCALE(Height.SCALE, 5),
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
	
    private static GameState state;
    private static Side robotSide;
    private static AutoType selectedAutoType;
    private static boolean flipped;
	
    public AutoRoutines() {
    	state = new GameState(DriverStation.getInstance().getGameSpecificMessage());
    }
    
	public static void updateGameState() {
		state.updateGameState(DriverStation.getInstance().getGameSpecificMessage());
		
		robotSide = getRobotSide(state);
		selectedAutoType = getAutoType(getSelectedAutoMode(), state, robotSide);
		flipped = robotSide == Side.RIGHT;
		
		putSmartDash();
	}
	
	/* 
	 * Base on Robot Position on the alliance wall & plates states, determines 
	 * which auto routine to run, gripper height, and whether left & right motion
	 * profiles need to be reverse base on field symmetry.
	 * 
	 */
	public static Command getAutoRoutine () {

		updateGameState();
		
		HelixEvents.addEvent("ROBOT", "Selected Auto Mode: " + selectedAutoType.name() + ", flipped: " + flipped);
		
//		if (selectedAutoType == AutoType.OPPOSITE_SIDE_SCALE) {
//			return new FollowTrajectory(new OppositeSideScale(flipped));
//		}
		
		switch (selectedAutoType) {
		case BASELINE:
			return new BaselineAutoGroup(flipped);
		case CENTER_SWITCH:
			return new AutoGroup(
					new CenterSwitch(flipped), 
					selectedAutoType.getHeight(),
					selectedAutoType.getDelay(),
					new CenterSwitchPhase2(flipped));
//					null);
		case OPPOSITE_SIDE_SCALE:
			return new AutoGroupNoDeliver(
					new OppositeSideScale(flipped), 
					selectedAutoType.getHeight(),
					selectedAutoType.getDelay(),
//					new OppositeSideScalePhase2(flipped));
					null);
		case SAME_SIDE_SCALE:
			return new AutoGroup(
					new SameSideScale(flipped), 
					selectedAutoType.getHeight(),
					selectedAutoType.getDelay(),
					new SameSideScalePhase2(flipped));
//					null);
		case SAME_SIDE_SWITCH:
			return new SameSideSwitchGroup(
					flipped);
//					new SameSideSwitch(flipped), 
//					selectedAutoType.getHeight(),
//					selectedAutoType.getDelay(),
//					new SameSideSwitchPhase2(flipped));
//					null);
		case SCALE_TO_SWITCH:
			return new AutoGroup(
					new SameSideScale(flipped), 
					selectedAutoType.getHeight(),
					selectedAutoType.getDelay(),
//					new ScaleToSwitchPhase2(flipped));
					null);
		default:
			return new BaselineAutoGroup(flipped);
		}
		
//		if (selectedAutoType == AutoType.SAME_SIDE_SWITCH) {
//				return new SameSideSwitchGroup(flipped);
//		}
		
//		return new AutoGroup(
//				getPath(selectedAutoType, flipped), 
//				selectedAutoType.getHeight(),
//				selectedAutoType.getDelay(),
//				getPhase2(selectedAutoType, flipped));
	}
	
	private static Side getRobotSide(GameState state) {
		if (!centerSwitch.get()) {
			return state.mySwitchSide; 
		} else {
			if (!left.get()) {
				return Side.LEFT;
			} else {
				return Side.RIGHT;
			} 
		}
	}
	
	private static AutoMode getSelectedAutoMode() {
		if (!centerSwitch.get()) {
			return AutoMode.CENTER_SWITCH;
		} else if (!ourSideOnly.get()) {  // Our Side only auto
			return AutoMode.OUR_SIDE_ONLY;
		} else if (!switchScaleScale.get()) { 
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
	
	public static void putSmartDash() {
		
		SmartDashboard.putString("Robot Location", !left.get()? "LEFT": (!right.get()? "RIGHT" : "CENTER"));
		SmartDashboard.putString("Auto Mode", getSelectedAutoMode().name());
		
		SmartDashboard.putBoolean("Center Switch", !centerSwitch.get());
		SmartDashboard.putBoolean("Our Side Only", !ourSideOnly.get());
		SmartDashboard.putBoolean("Switch Scale Scale", !switchScaleScale.get());
		SmartDashboard.putBoolean("Scale Only", !scaleOnly.get());
		
		SmartDashboard.putString("Our Switch", state.mySwitchSide.name());
		SmartDashboard.putString("Our Scale", state.scaleSide.name());
		SmartDashboard.putString("Their Switch", state.theirSwitchSide.name());
	
		SmartDashboard.putBoolean("Flipped", robotSide == Side.RIGHT);
		SmartDashboard.putString("Auto Type", selectedAutoType.name());
		
	}
}