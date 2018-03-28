
package org.usfirst.frc.team2363.robot;

import org.iif.th.util.logger.HelixEvents;
import org.iif.th.util.logger.HelixLogger;
import org.usfirst.frc.team2363.robot.commands.autonomous.AutoRoutines;
import org.usfirst.frc.team2363.robot.subsystems.Claws;
import org.usfirst.frc.team2363.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2363.robot.subsystems.Elevator;
import org.usfirst.frc.team2363.robot.subsystems.Gripper;
import org.usfirst.frc.team2363.robot.subsystems.Tramps;
import org.usfirst.frc.team319.arcs.SameSideSwitchArc;
import org.usfirst.frc.team319.arcs.scaling_calibrationArc;
import org.usfirst.frc.team319.arcs.turning_calibrationArc;
import org.usfirst.frc.team319.robot.commands.FollowArc;

import com.ctre.phoenix.sensors.PigeonIMU;

//import com.ctre.phoenix.sensors.PigeonIMU;
//import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
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
	public static Gripper gripper;
	public static Tramps tramps;
	public static Elevator elevator;
	public static Claws claws;
	
	public static AutoRoutines autoRoutines = new AutoRoutines();
	private static DigitalInput autoOverride = new DigitalInput(6);  // default
	
	// declare SmartDashboard tools
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	public static HelixLogger LOG;
	
	public Robot() {
      
		LOG = new HelixLogger();
	  
		gripper = new Gripper();
		drivetrain = new Drivetrain();
		tramps = new Tramps();
		elevator = new Elevator();
		claws = new Claws();
		
		LOG.addSource("Total Current", pdp, f -> "" + ((PowerDistributionPanel)f).getTotalCurrent());
		LOG.addSource("COMPRESSOR State", compressor, f -> "" + ((Compressor)f).enabled());
		LOG.addSource("COMPRESSOR Current", compressor, f -> "" + ((Compressor)(f)).getCompressorCurrent());
	}
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Create the controller interface
		oi = new OI();
    		
		elevator.reset();
		CameraServer.getInstance().startAutomaticCapture();
//		PigeonIMU.EnterCalibrationMode(CalibrationMode.Temperature);
//		PigeonIMU.EnableTemperatureCompensation(false);
//		drivetrain.getRight().setSelectedSensorPosition(0, 0, 0);
//		drivetrain.getRight().setSelectedSensorPosition(0, 1, 0);
//		drivetrain.getRight().getSensorCollection().setQuadraturePosition(0, 0);
//		drivetrain.getLeft().getSensorCollection().setQuadraturePosition(0, 0);
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
		elevator.goTo(elevator.getPosition());
		
		AutoRoutines.updateGameState();
	}

	@Override
	public void autonomousInit() {
		drivetrain.resetAngle();
	
			
//		autonomousCommand = new FollowTrajectory(new SameSideScalePart2());
//		autonomousCommand = new AutoGroup(new SameSideScale(), Height.SCALE, 2.5, new SameSideScalePhase2());
//		autonomousCommand = new AutoGroup(new SameSideScale(), Height.SCALE, 2.5, new ScaleToSwitchPhase2());
//		autonomousCommand = new AutoGroup(new OppositeSideScale(), Height.SCALE, 7.5, new OppositeSideScalePhase2(false));
//		autonomousCommand = new FollowTrajectory(new Baseline());
//		autonomousCommand = new AutoGroup(new SameSideSwitch(), Height.SWITCH, 3, new SameSideSwitchPhase2());
//		if (!autoOverride.get()) {
//			autonomousCommand = new FollowTrajectory(new SameSideScale(true));
			autonomousCommand = new FollowArc(new SameSideSwitchArc());
//		} else {
//			autonomousCommand = AutoRoutines.getAutoRoutine();
//		}
		
//		autonomousCommand = new FollowTrajectory(new SameSideScale(true));
//		autonomousCommand = new RaiseElevator(Height.DROP);
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

//		LOG.saveLogs();
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
