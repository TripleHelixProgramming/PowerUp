
package org.usfirst.frc.team2363.robot;

import org.iif.th.util.logger.HelixLogger;

import org.usfirst.frc.team2363.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team2363.robot.subsystems.Gripper;
import org.usfirst.frc.team2363.robot.subsystems.Tramps;
import org.usfirst.frc.team2363.util.pathplanning.commands.PathRunner;
import org.usfirst.frc.team2363.util.pathplanning.AutoRoutines;
import org.usfirst.frc.team2363.util.pathplanning.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;

import org.usfirst.frc.team2363.robot.commands.autonomous.AutoGroup;
import org.usfirst.frc.team2363.robot.commands.autonomous.BaselineAutoGroup;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// Declare operator interface class - the controller
	public static OI oi;
	
	// Subsystems
	public static Drivetrain drivetrain;
	private final PowerDistributionPanel pdp = new PowerDistributionPanel();
	private final Compressor compressor = new Compressor();
	public static Gripper gripper = new Gripper();
	public static Tramps tramps;
	
	public static AutoRoutines autoRoutines;
	
	// declare SmartDashboard tools
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	public static HelixLogger LOG;
	
	
	//Placeholder Variables
//	String switchHeight;
//	String scaleHeight;
//	String centerSwitchLeft;
//	String centerSwitchRight;
//	String leftSwitch;
//	String rightSwitch;
//	String leftScaleLeft;
//	String leftScaleRight;
//	String rightScaleRight;
//	String rightScaleLeft;
//	String baseline;
	
	public Robot() {
      
		LOG = new HelixLogger();
	  
		drivetrain = new Drivetrain();
		tramps = new Tramps();
		autoRoutines = new AutoRoutines();
		
		LOG.addSource("Total Current", pdp, f -> "" + ((PowerDistributionPanel)f).getTotalCurrent());
		LOG.addSource("Compressor State", compressor, f -> "" + ((Compressor)f).enabled());
	}
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Create the controller interface
		oi = new OI();
		autonomousCommand = new PathRunner("scaling_calibration");
		
		CameraServer.getInstance().startAutomaticCapture();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		oi.setControllerRumble(false);
	}

	@Override
	public void disabledPeriodic() {
		// makes sure only one command per subsystems runs at a time
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
			
		//   Set plate states
		autoRoutines.obtainPlateStates();
		
		AutoGroup autoGroup = new AutoGroup(autoRoutines.getPath(), autoRoutines.getHeight(), autoRoutines.getReverse());
		autonomousCommand = autoGroup;
//		autonomousCommand = new PathRunner("scaling_calibration");
		
		if (autonomousCommand != null)
			autonomousCommand.start();
		

		
//		AutoGroup centerswitchleft = new AutoGroup(centerSwitchLeft, Height.SWITCH);
//		AutoGroup centerswitchright = new AutoGroup(centerSwitchRight, Height.SWITCH);
//		AutoGroup leftswitchleft = new AutoGroup(leftSwitch, Height.SWITCH);
//		AutoGroup rightswitchright = new AutoGroup(rightSwitch, Height.SWITCH);
//		AutoGroup leftscaleleft = new AutoGroup(leftScaleLeft, Height.SCALE);
//		AutoGroup leftscaleright = new AutoGroup(leftScaleRight, Height.SCALE);
//		AutoGroup rightscaleright = new AutoGroup(rightScaleRight, Height.SCALE);
//		AutoGroup rightscaleleft = new AutoGroup(rightScaleLeft, Height.SCALE);
//		BaselineAutoGroup baseline = new BaselineAutoGroup(baseline);
//		AutoGroup sideswitch = null;
//		AutoGroup samesidescale = null;
//		AutoGroup oppositesidescale = null;
//		AutoGroup scale = null;
//	
//		char robotPosition = 0;
//		if (autoLeft.get()) {
//			robotPosition = 'L';
//			sideswitch = leftswitchleft;
//			samesidescale = leftscaleleft;
//			oppositesidescale = leftscaleright;
//		} else if (!autoRight.get()) {
//			robotPosition = 'R';
//			sideswitch = rightswitchright;
//			samesidescale = rightscaleright;
//			oppositesidescale = rightscaleleft;
//		}
//		
//		if (autoSwitch.get()) {
//			if (gameData.charAt(0) == 'L') {
//				autonomousCommand = centerswitchleft;
//			} else {
//				autonomousCommand = centerswitchright;
//			}
//		} else if (autoSwitchScaleBaseline.get()) {
//			if (gameData.charAt(0) == robotPosition) {
//				autonomousCommand = sideswitch;
//			} else if (gameData.charAt(1) == robotPosition) {
//				autonomousCommand = samesidescale;
//			} else {
//				autonomousCommand = baseline;
//			}
//		} else if (autoSwitchScaleScale.get()) {
//			if (gameData.charAt(0) == robotPosition) {
//				autonomousCommand = sideswitch;
//			} else if (gameData.charAt(1) == robotPosition){
//				autonomousCommand = samesidescale;
//			} else {
//				autonomousCommand = oppositesidescale;
//			}
//		} else {
//			if (gameData.charAt(1) == robotPosition){
//				autonomousCommand = samesidescale;
//			} else {
//				autonomousCommand = oppositesidescale;
//			}
//		}

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		// makes sure only one command per subsystems runs at a time
		Scheduler.getInstance().run();

		LOG.saveLogs();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// makes sure only one command per subsystems runs at a time
		Scheduler.getInstance().run();
		
		LOG.saveLogs();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		// brings up a window with the state of the robot parts
	}
}
