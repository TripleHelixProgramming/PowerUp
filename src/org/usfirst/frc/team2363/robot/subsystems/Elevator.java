package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.elevator.ManualPositionalElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Elevator extends Subsystem {
	
	public enum Height {
		
		GROUND(0),
		SWITCH(1125),
		SCALE(4500),
		RUNG(2);
		
		private final double height;
		
		private Height(double height) {
			this.height = height;
		}
		
		public double getHeight() {
			return height;
		}
	}
	
	public static final int MAX_HEIGHT = 4500;
	public static final int MIN_HEIGHT = 0;
	
	private TalonSRX leftMotor = new TalonSRX(RobotMap.LEFT_ELEVATOR_MOTOR);
	private TalonSRX rightMotor = new TalonSRX(RobotMap.RIGHT_ELEVATOR_MOTOR);
	
	public Elevator() {
		rightMotor.set(ControlMode.Follower, leftMotor.getDeviceID());
		rightMotor.setNeutralMode(NeutralMode.Brake);
		rightMotor.configOpenloopRamp(0.2, 0);
		leftMotor.setNeutralMode(NeutralMode.Brake);
		leftMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
		leftMotor.overrideLimitSwitchesEnable(true);
		leftMotor.config_kP(0, 5, 10);
		leftMotor.config_kD(0, 4000, 10);
		leftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		leftMotor.configMotionCruiseVelocity(700, 0);
		leftMotor.configMotionAcceleration(10000, 0);
	}

	@Override
	public void periodic() {
		SmartDashboard.putNumber("Encoder Position", getPosition());
		SmartDashboard.putNumber("Elevator Velocity", getVelocity());
		if (leftMotor.getSensorCollection().isRevLimitSwitchClosed()) {
			SmartDashboard.putBoolean("Limit Switch", true);
			leftMotor.getSensorCollection().setQuadraturePosition(0, 0);
		} else {
			SmartDashboard.putBoolean("Limit Switch", false);
		}
	}
	
	public double getPosition() {
		return leftMotor.getSensorCollection().getQuadraturePosition();
	}
	
	public double getVelocity() {
		return leftMotor.getSensorCollection().getQuadratureVelocity();
	}
	
	public void goTo (Height height) {
		goTo(height.getHeight());
	}
	
	public void goTo(double height) {
		leftMotor.set(ControlMode.MotionMagic, height);
	}
	
	protected void initDefaultCommand() {
		// sets the default drive mode to Colson drive
  		setDefaultCommand(new ManualPositionalElevator());
	}
}
