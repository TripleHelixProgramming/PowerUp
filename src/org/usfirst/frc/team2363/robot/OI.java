package org.usfirst.frc.team2363.robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.commands.drivetrain.OmniDrive;
import org.usfirst.frc.team2363.robot.commands.drivetrain.TractionDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick driverController;
	private Joystick operatorController;
	private Joystick driverRumble;
	private Joystick operatorRumble;

	public OI() {
		//Controllers
		driverController = new Joystick(DRIVER_PORT);
		operatorController = new Joystick(OPERATOR_PORT);
		driverRumble = new Joystick(DRIVER_RUMBLE_PORT);
		operatorRumble = new Joystick(OPERATOR_RUMBLE_PORT);
		
		//Turns on Omni Drive
		new JoystickButton(driverController, R1).whenPressed(new OmniDrive());
		//Turns on Traction Drive
		new JoystickButton(driverController, R2).whenPressed(new TractionDrive());
		
		Robot.LOG.addSource("Raw Throttle", driverController, f -> "" + ((Joystick)f).getRawAxis(LEFT_STICK_Y));
		Robot.LOG.addSource("Raw Turn", driverController, f -> "" + ((Joystick)f).getRawAxis(RIGHT_STICK_X));
		Robot.LOG.addSource("Scaled Throttle", this, f -> "" + ((OI)f).getThrottle() * Math.abs(((OI)f).getThrottle()));
		Robot.LOG.addSource("Scaled Turn", this, f -> "" + ((OI)f).getTurn() * Math.abs(((OI)f).getTurn()));
		
	}
	
	// omni wheels
	public boolean isOmnisDeployed() {
		return(driverController.getRawButton(R1) == true);
	}
	
	// speed
	public double getThrottle () {
		return driverController.getRawAxis(LEFT_STICK_Y);
	}
	
	// turn angle
	public double getTurn() {
		return driverController.getRawAxis(RIGHT_STICK_X) * getTurnScaling(getThrottle());
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
			driverRumble.setRumble(RumbleType.kLeftRumble, 1);
			driverRumble.setRumble(RumbleType.kRightRumble, 1);
			operatorRumble.setRumble(RumbleType.kLeftRumble, 1);
			operatorRumble.setRumble(RumbleType.kRightRumble, 1);
		} else {
			driverRumble.setRumble(RumbleType.kLeftRumble, 0);
			driverRumble.setRumble(RumbleType.kRightRumble, 0);
			operatorRumble.setRumble(RumbleType.kLeftRumble, 0);
			operatorRumble.setRumble(RumbleType.kRightRumble, 0);
		}
	}
}
