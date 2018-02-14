
package org.usfirst.frc.team2363.robot;

import org.iif.th.util.logger.HelixEvents;
import org.iif.th.util.logger.HelixLogger;
import org.usfirst.frc.team2363.robot.commands.autonomous.AutoRoutines;
import org.usfirst.frc.team2363.robot.commands.autonomous.PathTesting;
import org.usfirst.frc.team2363.robot.subsystems.Claws;
import org.usfirst.frc.team2363.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2363.robot.subsystems.Elevator;
import org.usfirst.frc.team2363.robot.subsystems.Gripper;
import org.usfirst.frc.team2363.robot.subsystems.Tramps;
import org.usfirst.frc.team319.utils.SrxTrajectoryImporter;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
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
	public static Gripper gripper = new Gripper();
	public static Tramps tramps;
	public static Elevator elevator = new Elevator();
	public static Claws claws = new Claws();
	
	public static AutoRoutines autoRoutines;
	
	// declare SmartDashboard tools
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	public static HelixLogger LOG;
	private static final SrxTrajectoryImporter importer = new SrxTrajectoryImporter("/home/lvuser/Autos");
	
	public Robot() {
      
		LOG = new HelixLogger();
	  
		drivetrain = new Drivetrain();
		tramps = new Tramps();
//		autoRoutines = new AutoRoutines();
		
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
		try {
			autonomousCommand = new PathTesting();
		} catch(Exception e) { 
			e.printStackTrace();
		}
		
//		CameraServer.getInstance().startAutomaticCapture();
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
//		autoRoutines.obtainPlateStates();
		
//		AutoGroup autoGroup = new AutoGroup(autoRoutines.getPath(), autoRoutines.getHeight(), autoRoutines.getReverse());
//		autonomousCommand = autoGroup;
//		autonomousCommand = new PathRunner("scaling_calibration");
		
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
		HelixEvents.startLogging();
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
