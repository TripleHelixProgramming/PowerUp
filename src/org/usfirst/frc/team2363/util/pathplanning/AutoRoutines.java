package org.usfirst.frc.team2363.util.pathplanning;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team2363.util.pathplanning.SrxPathReader;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;

public class AutoRoutines {
	
	// AutoType Order must match paths order below.
	public enum AutoTypeEnum {
		CENTER_SWITCH,
		SAME_SIDE_SWITCH,
		SAME_SIDE_SCALE,
		OPPOSITE_SIDE_SCALE,
		BASELINE,
		PATH_TO_CUBE,
		SHORT_PATH
	}
	/*
	 * Names of autonomous path files. Order must match AutoType enum above.  Use
	 * the BobTracjectory tool in the ui_refactor branch to create the left robot position
	 * version for all these paths.  Right robot positions are executed by inverting the 
	 * right & left motor profiles.
	 */
	
	private String[] paths = {
		"CenterSwitch",
		"SameSideSwitch",
		"SameSideScale",
		"OppositeSideScale",
		"Baseline",
		"PathToCube",
		"ShortPath",
	};
	
	private AutoTypeEnum autoType = AutoTypeEnum.BASELINE;
	private String gameData;
    char ourSwitch, opponentSwitch, scale, robotPosition;
	private Height height;
	private Boolean reverse = false;
	
	// Hash map allowing look ups of path object based on autonomous path file name. 
	Map<String, BoTHTrajectory> autoMap = new HashMap<String, BoTHTrajectory>();
	BoTHTrajectory auto;
	
	public AutoRoutines() {
		loadPaths();
	}
	
	/* 
	 * Read the autonomous digital switch selections &  Load all the autonomous paths to save time during autonomous.  
	 * This routine should be called in RobotInit.
	 */
	public void loadPaths() {
		
		readAutoSwitch();
		for (String path: paths) {
			auto = SrxPathReader.importSrxTrajectory(path);
			autoMap.put(path, auto);
		}
	}
	
	/* 
	 * Base on Robot Position on the alliance wall & plates states, determines 
	 * which auto routine to run, gripper height, and whether left & right motion
	 * profiles need to be reverse base on field symmetry.
	 * 
	 */
	public void readAutoSwitch () {
		
		DigitalInput Left = new DigitalInput(0);
		DigitalInput Right = new DigitalInput(1);
		DigitalInput CenterSwitch = new DigitalInput(2);
		DigitalInput OurSideOnly = new DigitalInput(3);
		DigitalInput SwitchScaleScale = new DigitalInput(4);
		DigitalInput ScaleOnly = new DigitalInput(5);  // default
			
		/*
		 *  Switch left & right motor profiles, if robot is on right side of the alliance
		 *  wall, when facing the field  OR  if robot is at center of alliance wall & our 
		 *  switch plate is on the right.    
		 */
		if (Left.get()) {
			robotPosition = 'L';
			reverse = false;
		} else if (Right.get()) {
			robotPosition = 'R';
			reverse = true;
		} else {   // Center Switch
			// Motor profile reverse is based on switch location in CenterSwitch case
			reverse = (ourSwitch == 'R')? true : false; 
		}
		
		height = Height.SWITCH;	
		
		if (CenterSwitch.get()) {
			autoType = AutoTypeEnum.CENTER_SWITCH;
		} else if (OurSideOnly.get()) {  // Our Side only auto
			if (ourSwitch == robotPosition) {
				// Switch is on our side. Go for the switch first over the scale.
				autoType = AutoTypeEnum.SAME_SIDE_SWITCH;
			} else if (scale == robotPosition) {
				// Switch is not on our side, but scale is.
				autoType = AutoTypeEnum.SAME_SIDE_SCALE;
				height = Height.SCALE;
			} else {  
				// Neither the Switch nor the Scale are on our side.
				autoType = AutoTypeEnum.BASELINE;
				height = Height.GROUND;
			}
		} else if (SwitchScaleScale.get()) { 
			if (ourSwitch == robotPosition) {
				// Switch is on our side. Go for the switch first over the scale.
				autoType = AutoTypeEnum.SAME_SIDE_SWITCH;
			} else if (scale == robotPosition){
				// Switch is not on our side, but scale is. Go for scale.
				autoType = AutoTypeEnum.SAME_SIDE_SCALE;
				height = Height.SCALE;
			} else { 
				// Neither the Switch nor the Scale are on our side. Go for opposite side scale. 
				autoType = AutoTypeEnum.OPPOSITE_SIDE_SCALE;
				height = Height.SCALE;
			}
		} else {  // ScaleOnly run
			height = Height.SCALE;
			if (scale == robotPosition){
				autoType = AutoTypeEnum.SAME_SIDE_SCALE;
			} else {
				autoType = AutoTypeEnum.OPPOSITE_SIDE_SCALE;
			}
		}
	}
	
	/* 
	 * Get the locations of the switches and scale with respect to our alliance wall. 
	 */
	public void obtainPlateStates() {

		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		ourSwitch = gameData.charAt(0);
		scale = gameData.charAt(1);
		opponentSwitch = gameData.charAt(2);
		
	}
	
	public BoTHTrajectory getPath () {
		return (BoTHTrajectory) (autoMap.get(paths[autoType.ordinal()]));
	}
	
	public BoTHTrajectory getPath (AutoTypeEnum autoType) {
		return (BoTHTrajectory) (autoMap.get(paths[autoType.ordinal()]));
	}
	
	public Height getHeight() {
		return height;
	}
	
	public boolean getReverse() {
		return reverse;
	}
}