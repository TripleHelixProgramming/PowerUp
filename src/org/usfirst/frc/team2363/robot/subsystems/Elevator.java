package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.drivetrain.JoystickDrive;
import org.usfirst.frc.team2363.robot.commands.elevator.OperateElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	
	private static final int MAX_HEIGHT = 4500;
	private static final int MIN_HEIGHT = 0;
	
	public Elevator() {
		rightMotor.set(ControlMode.Follower, leftMotor.getDeviceID());
		rightMotor.setNeutralMode(NeutralMode.Brake);
		rightMotor.configOpenloopRamp(0.2, 10);
		leftMotor.setNeutralMode(NeutralMode.Brake);
		leftMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
		leftMotor.overrideLimitSwitchesEnable(true);
		leftMotor.configOpenloopRamp(0.2, 10);
	}
	
	private TalonSRX leftMotor = new TalonSRX(RobotMap.LEFT_ELEVATOR_MOTOR);
	private TalonSRX rightMotor = new TalonSRX(RobotMap.RIGHT_ELEVATOR_MOTOR);
	private DigitalInput defaultPosition = new DigitalInput(RobotMap.DEFAULT_POSITION);
//	private DigitalInput groundLimit = new DigitalInput(RobotMap.ELEVATOR_GROUND_LIMIT_CHANNEL);
//	private DigitalInput upperLimit = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT_CHANNEL);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void elevate (double power) {
		if (power > 0.0) {
			if (getPosition() >= MAX_HEIGHT) {
				setPower(0);
			} else if (getPosition() > .70 * MAX_HEIGHT) {
				setPower(Math.min(.6, power));
			} else {
				setPower(power * 0.8);
			}
		} else	{
			if (getPosition() <= MIN_HEIGHT) {
				setPower(0);
			} else if (getPosition() < .30 * MAX_HEIGHT) {
				if (getVelocity() <= -400) {
					setPower(Math.max(0, power));
				} else {
					setPower(Math.max(-.25,  power));
				}
			} else {
				setPower(power * 0.55);
			}
		}
	}
@Override
	public void periodic() {
		SmartDashboard.putNumber("Encoder Position", getPosition());
		SmartDashboard.putNumber("Elevator Velocity", getVelocity());
		if (leftMotor.getSensorCollection().isRevLimitSwitchClosed()) {
			SmartDashboard.putBoolean("Limit Switch", true);
			leftMotor.getSensorCollection().setQuadraturePosition(0, 0);
//			leftMotor.setSelectedSensorPosition(0, 0, 10);
		} else {
//			leftMotor.setSelectedSensorPosition(0, 0, 10);
			SmartDashboard.putBoolean("Limit Switch", false);
		}
	}
	
	public double getPosition() {
		return leftMotor.getSensorCollection().getQuadraturePosition();
//		return leftMotor.getSelectedSensorPosition(0);
	}
	
	public double getVelocity() {
		return leftMotor.getSensorCollection().getQuadratureVelocity();
	}
	
	private void setPower(double power) {
		if (power < 0.1 && power > -0.1 && getPosition() != 0) {
			leftMotor.set(ControlMode.PercentOutput, 0.1, 10);
		} else {
			leftMotor.set(ControlMode.PercentOutput, Math.abs(power) * power, 10);
		}
	}
	
	public void goTo (Height height) {
		leftMotor.set(ControlMode.Position, height.getHeight());
	}
	protected void initDefaultCommand() {
		// sets the default drive mode to Colson drive
  		setDefaultCommand(new OperateElevator());
	}
}
