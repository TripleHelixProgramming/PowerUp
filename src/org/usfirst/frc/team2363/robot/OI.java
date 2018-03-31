package org.usfirst.frc.team2363.robot;

import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.commands.claws.CloseClaw;
import org.usfirst.frc.team2363.robot.commands.claws.OpenClaw;
import org.usfirst.frc.team2363.robot.commands.climber.ExtendClimber;
import org.usfirst.frc.team2363.robot.commands.climber.RetractClimber;
import org.usfirst.frc.team2363.robot.commands.drivetrain.JoystickDrive;
import org.usfirst.frc.team2363.robot.commands.drivetrain.TurboDrive;
import org.usfirst.frc.team2363.robot.commands.elevator.ManualPositionalElevator;
import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.elevator.ResetElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.EjectCube;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.commands.gripper.ShootCube;
import org.usfirst.frc.team2363.robot.subsystems.Elevator;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private XboxController driverController;
	private XboxController operatorController;

	public OI() {
		//Controllers
		driverController = new XboxController(DRIVER_PORT);
		operatorController = new XboxController(OPERATOR_PORT);
		
		new JoystickButton(operatorController, RobotMap.X).whileHeld(new IntakeCube());
		new JoystickButton(operatorController, RobotMap.B).whileHeld(new EjectCube());
		new JoystickButton(operatorController, RobotMap.Y).whileHeld(new ShootCube());//originally shootCube
		new JoystickButton(operatorController, RobotMap.RB).whenPressed(new OpenClaw());
		new JoystickButton(operatorController, RobotMap.LB).whenPressed(new CloseClaw());
		new JoystickButton(operatorController, RobotMap.A).whenPressed(new ManualPositionalElevator());
//		new JoystickButton(driverController, RobotMap.RB).whenPressed(new SlowJoystickDrive());
//		new JoystickButton(driverController, RobotMap.RB).whenReleased(new JoystickDrive());
		
		new JoystickButton(operatorController, RobotMap.LOGO_LEFT).whenPressed(new ResetElevator());
		
//		Button drive = new Button() {
//
//			@Override
//			public boolean get() {
//				return driverController.getRawAxis(RIGHT_TRIGGER) >= 0.5;
//			}
//		};
//		drive.whenPressed(new SlowJoystickDrive());
//		
//		drive.whenReleased(new JoystickDrive());
		
		Button turbo = new Button() {

			@Override
			public boolean get() {
				return driverController.getRawAxis(RIGHT_TRIGGER) >= 0.5;
			}
		};
		
		Button climberElevator = new Button() {

			@Override
			public boolean get() {
				return operatorController.getRawAxis(RIGHT_TRIGGER) >= 0.5;
			}
		};
//		Button climberRetract = new Button() {
//
//			@Override
//			public boolean get() {
//				return operatorController.getRawAxis(LEFT_TRIGGER) >= 0.5;
//			}
//		};
		
		turbo.whenPressed(new TurboDrive());
		
		turbo.whenReleased(new JoystickDrive());
		
		climberElevator.whenPressed(new RaiseElevator(Elevator.Height.CLIMBER));
		
//		climberRetract.whenPressed(new RetractClimber());
		
		new Button() {

			@Override
			public boolean get() {
				return operatorController.getPOV() == 180;
			}
		}.whenPressed(new RaiseElevator(Height.GROUND));
		
		new Button() {

			@Override
			public boolean get() {
				return operatorController.getPOV() == 270;
			}
		}.whenPressed(new RaiseElevator(Height.SWITCH));
		
		new Button() {

			@Override
			public boolean get() {
				return operatorController.getPOV() == 0;
			}
		}.whenPressed(new RaiseElevator(Height.SCALE));
		
/*		new Button() {

			@Override
			public boolean get() {
				return operatorController.getRawAxis(LEFT_TRIGGER) >= 0.5;
			}
			 
		}.whenPressed(new ResetElevator());*/
		
		new Button() {

			@Override
			public boolean get() {
				return operatorController.getPOV() == 90;
			}
		}.whenPressed(new RaiseElevator(Height.ROTATE));
		
		Robot.LOG.addSource("Raw Throttle", driverController, f -> "" + ((XboxController)f).getRawAxis(LEFT_STICK_Y));
		Robot.LOG.addSource("Raw Turn", driverController, f -> "" + ((XboxController)f).getRawAxis(RIGHT_STICK_X));
		Robot.LOG.addSource("Scaled Throttle", this, f -> "" + ((OI)f).getThrottle() * Math.abs(((OI)f).getThrottle()));
		Robot.LOG.addSource("Scaled Turn", this, f -> "" + ((OI)f).getTurn() * Math.abs(((OI)f).getTurn()));
		
		
		
	}
	
	// speed
	public double getThrottle () {
		return driverController.getRawAxis(1); //originally LEFT_STICK_Y
	}
	
	// turn angle
	public double getTurn() {
		return driverController.getRawAxis(4) * getTurnScaling(getFullSpeedPercentage());//originally RIGHT_STICK_X
	}
	
	public double getElevatorPower() {
		double stick = -operatorController.getRawAxis(LEFT_STICK_Y);
		stick *= Math.abs(stick);
		if (Math.abs(stick) < 0.05) {
			stick = 0;
		}
		return stick;
	}
	
	public double getFullSpeedPercentage() {
		return Math.min(1, Robot.drivetrain.getRobotSpeedPercent());
	}
	
	public static double getTurnScaling(double x) {
		return -Math.abs(LOW_SPEED_SCALING - HIGH_SPEED_SCALING) * Math.abs(x) + LOW_SPEED_SCALING;
	}
	
	//Climber Power
	public double getClimberPower() {
		double stick = -operatorController.getRawAxis(RIGHT_STICK_Y);
		stick *= Math.abs(stick);
		if (Math.abs(stick) < 0.05) {
			stick = 0;
		}
		return stick;
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
