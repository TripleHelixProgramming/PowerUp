package org.usfirst.frc.team2363.robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;

import static org.usfirst.frc.team2363.robot.RobotMap.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick driverController;
	private Joystick operatorController;

	public OI() {
		//Controllers
		driverController = new Joystick(DRIVER_PORT);
		operatorController = new Joystick(OPERATOR_PORT);
		
		Robot.LOG.addSource("Raw Throttle", driverController, f -> "" + ((Joystick)f).getRawAxis(LEFT_STICK_Y));
		Robot.LOG.addSource("Raw Turn", driverController, f -> "" + ((Joystick)f).getRawAxis(RIGHT_STICK_X));
		Robot.LOG.addSource("Scaled Throttle", this, f -> "" + ((OI)f).getThrottle() * Math.abs(((OI)f).getThrottle()));
		Robot.LOG.addSource("Scaled Turn", this, f -> "" + ((OI)f).getTurn() * Math.abs(((OI)f).getTurn()));
		
		
		
	}
	
	// speed
	public double getThrottle () {
		return driverController.getRawAxis(LEFT_STICK_Y);
	}
	
	// turn angle
	public double getTurn() {
		return driverController.getRawAxis(RIGHT_STICK_X) * getTurnScaling(getFullSpeedPercentage());
	}
	
	public double getElevatorPower() {
		return -operatorController.getRawAxis(LEFT_STICK_Y);
	}
	
	public double getFullSpeedPercentage() {
		return Math.min(1, Robot.drivetrain.getRobotSpeedPercent());
	}
	
	public static double getTurnScaling(double x) {
		return -Math.abs(LOW_SPEED_SCALING - HIGH_SPEED_SCALING) * Math.abs(x) + LOW_SPEED_SCALING;
	}
	
	
	
	/**
	 * Turns on and off the rumble function on the driver and operator controllers
	 * @param set true to turn on rumble
	 */
	public void setControllerRumble(boolean state) {
		if (state == true) {
			driverController.setRumble(RumbleType.kLeftRumble, 1);
			driverController.setRumble(RumbleType.kRightRumble, 1);
			operatorController.setRumble(RumbleType.kLeftRumble, 1);
			operatorController.setRumble(RumbleType.kRightRumble, 1);
		} else {
			driverController.setRumble(RumbleType.kLeftRumble, 0);
			driverController.setRumble(RumbleType.kRightRumble, 0);
			operatorController.setRumble(RumbleType.kLeftRumble, 0);
			operatorController.setRumble(RumbleType.kRightRumble, 0);
		}
	}
}
