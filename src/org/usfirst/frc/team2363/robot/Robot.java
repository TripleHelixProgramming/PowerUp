
package org.usfirst.frc.team2363.robot;

import org.iif.th.util.logger.HelixLogger;
import org.usfirst.frc.team2363.robot.commands.autonomous.AutoGroup;
import org.usfirst.frc.team2363.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2363.util.pathplanning.commands.FollowTrajectory;
import org.usfirst.frc.team2363.util.pathplanning.commands.PathRunner;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

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
	
	// declare SmartDashboard tools
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	public static HelixLogger LOG;
	
	public Robot() {
      
		LOG = new HelixLogger();
	  
		drivetrain = new Drivetrain();

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
		String switchHeight;
		String scaleHeight;
		
		autonomousCommand = new PathRunner("scaling_calibration");
//		autonomousCommand = new FollowTrajectory("scaling_calibration");
		
		AutoGroup centerswitchleft = new AutoGroup(centerSwitchLeftPath, switchHeight);
		AutoGroup centerswitchright = new AutoGroup(centerSwitchRightPath, switchHeight);
		AutoGroup leftswitchleft = new AutoGroup(leftSwitchPath, switchHeight);
		AutoGroup rightswitchright = new AutoGroup(rightSwitchPath, switchHeight);
		AutoGroup leftscaleleft = new AutoGroup(leftScaleRightPath, scaleHeight);
		AutoGroup leftscaleright = new AutoGroup(leftScaleRightPath, scaleHeight);
		AutoGroup rightscaleright = new AutoGroup(rightScaleRightPath, scaleHeight);
		AutoGroup rightscaleleft = new AutoGroup(rightScaleLeftPath, scaleHeight);

		
		if (autonomousCommand != null)
			autonomousCommand.start();
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
		LiveWindow.run();
	}
}
