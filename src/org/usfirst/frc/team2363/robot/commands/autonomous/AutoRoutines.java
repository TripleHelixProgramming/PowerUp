package org.usfirst.frc.team2363.robot.commands.autonomous;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.models.SrxTrajectory;
import org.usfirst.frc.team319.utils.SrxTrajectoryImporter;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoRoutines {
	
	// AutoType Order must match paths order below.
	public enum AutoType {
		CENTER_SWITCH("CameraSwitch"),
		SAME_SIDE_SWITCH("SameSideSwitch"),
		SAME_SIDE_SCALE("SameSideScale"),
		OPPOSITE_SIDE_SCALE("OpposideSideScale"),
		BASELINE("Baseline"),
		PATH_TO_CUBE("PathToCube"),
		SHORT_PATH("ShortPath");
		
		private String fileName;
		
		AutoType(String fileName) {
			this.fileName = fileName;
		}
		
		public String getFileName() {
			return fileName;
		}
	}
	
	private SrxTrajectoryImporter importer = new SrxTrajectoryImporter("/home/lvuser");
	
	private AutoType autoType = AutoType.BASELINE;
	private String gameData;
    char ourSwitch, opponentSwitch, scale, robotPosition;
	private Height height;
	private Boolean reverse = false;
	
	// Hash map allowing look ups of path object based on autonomous path file name. 
	Map<AutoType, SrxTrajectory> autoMap = new HashMap<AutoType, SrxTrajectory>();
	
	public AutoRoutines() {
		loadPaths();
	}
	
	/* 
	 * Read the autonomous digital switch selections &  Load all the autonomous paths to save time during autonomous.  
	 * This routine should be called in RobotInit.
	 */
	public void loadPaths() {
		try {
			for (AutoType path: AutoType.values()) {
				autoMap.put(path, importer.importSrxTrajectory(path.getFileName()));
			}
		} catch(Exception e) {
			e.printStackTrace();
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
		
		
		// Read the switch setting and plan auto routes based on plate locations above.
		determineAutoRoute();
		
		updateSmartDashboard();
		
	}
	
	/* 
	 * Base on Robot Position on the alliance wall & plates states, determines 
	 * which auto routine to run, gripper height, and whether left & right motion
	 * profiles need to be reverse base on field symmetry.
	 * 
	 */
	public void determineAutoRoute () {
		
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
			autoType = AutoType.CENTER_SWITCH;
		} else if (OurSideOnly.get()) {  // Our Side only auto
			if (ourSwitch == robotPosition) {
				// Switch is on our side. Go for the switch first over the scale.
				autoType = AutoType.SAME_SIDE_SWITCH;
			} else if (scale == robotPosition) {
				// Switch is not on our side, but scale is.
				autoType = AutoType.SAME_SIDE_SCALE;
				height = Height.SCALE;
			} else {  
				// Neither the Switch nor the Scale are on our side.
				autoType = AutoType.BASELINE;
				height = Height.GROUND;
			}
		} else if (SwitchScaleScale.get()) { 
			if (ourSwitch == robotPosition) {
				// Switch is on our side. Go for the switch first over the scale.
				autoType = AutoType.SAME_SIDE_SWITCH;
			} else if (scale == robotPosition){
				// Switch is not on our side, but scale is. Go for scale.
				autoType = AutoType.SAME_SIDE_SCALE;
				height = Height.SCALE;
			} else { 
				// Neither the Switch nor the Scale are on our side. Go for opposite side scale. 
				autoType = AutoType.OPPOSITE_SIDE_SCALE;
				height = Height.SCALE;
			}
		} else {  // ScaleOnly run
			height = Height.SCALE;
			if (scale == robotPosition){
				autoType = AutoType.SAME_SIDE_SCALE;
			} else {
				autoType = AutoType.OPPOSITE_SIDE_SCALE;
			}
		}
	}
	
	public SrxTrajectory getPath () {
		return autoMap.get(autoType);
	}
	
	public SrxTrajectory getPath (AutoType autoType) {
		return autoMap.get(autoType);
	}
	
	public Height getHeight() {
		return height;
	}
	
	public boolean getReverse() {
		return reverse;
	}
	
	private void updateSmartDashboard () {
		
		SmartDashboard.putString("Game Specific Message", gameData);
		SmartDashboard.putString("Our Switch Location", (ourSwitch == 'L')? "Left" : "Right");
		SmartDashboard.putString("Scale Location", (scale == 'L')? "Left" : "Right");
		SmartDashboard.putString("Opponent Switch Location", (opponentSwitch == 'L')? "Left" : "Right");
		
		SmartDashboard.putString("Robot Position", (robotPosition == 'L')? "Left" : (robotPosition == 'R')? "Right" : "Center");
		SmartDashboard.putString("Auto Routine Chosen", autoType.getFileName());
		SmartDashboard.putString("Gripper Height", height.toString());
	}
}