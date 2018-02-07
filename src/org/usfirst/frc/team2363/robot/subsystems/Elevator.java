package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.drivetrain.JoystickDrive;
import org.usfirst.frc.team2363.robot.commands.elevator.OperateElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Elevator extends Subsystem {
	
	public enum Height {
		
		GROUND(0),
		SWITCH(1),
		SCALE(2),
		RUNG(2);
		
		private final double height;
		
		private Height(double height) {
			this.height = height;
		}
		
		public double getHeight() {
			return height;
		}
	}
	
	private static final int MAX_HEIGHT = 4780;
	private static final int MIN_HEIGHT = 0;
	
	public Elevator() {
		rightMotor.set(ControlMode.Follower, leftMotor.getDeviceID());
		rightMotor.setNeutralMode(NeutralMode.Brake);
		leftMotor.setNeutralMode(NeutralMode.Brake);
	}
	
	private TalonSRX leftMotor = new TalonSRX(RobotMap.LEFT_ELEVATOR_MOTOR);
	private TalonSRX rightMotor = new TalonSRX(RobotMap.RIGHT_ELEVATOR_MOTOR);
	private DigitalInput defaultPosition = new DigitalInput(RobotMap.DEFAULT_POSITION);
//	private DigitalInput groundLimit = new DigitalInput(RobotMap.ELEVATOR_GROUND_LIMIT_CHANNEL);
//	private DigitalInput upperLimit = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT_CHANNEL);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void elevate (double power) {
		if (power > 0) {
			if (getPosition() >= MAX_HEIGHT) {
				setPower(0);
			} else if (getPosition() > .9 * MAX_HEIGHT) {
				setPower(Math.min(.25, power));
			} else {
				setPower(power);
			}
		} else	{
			if (getPosition() <= MIN_HEIGHT) {
				setPower(0);
			} else if (getPosition() < .1 * MAX_HEIGHT) {
				setPower(Math.max(-.25,  power));
			} else {
				setPower(power);
			}
		}
	}
	
	public double getPosition() {
		return leftMotor.getSelectedSensorPosition(0);
	}
	
	private void setPower(double power) {
		leftMotor.set(ControlMode.PercentOutput, power, 10);
	}
	
	public void goTo (Height height) {
		leftMotor.set(ControlMode.Position, height.getHeight());
	}
	protected void initDefaultCommand() {
		// sets the default drive mode to Colson drive
//		setDefaultCommand(new OperateElevator());
	}
}