package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.elevator.StopElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Elevator extends Subsystem {
	
	public enum Height {
		
		GROUND(0),
		ROTATE(390),
		SWITCH(1500),//original switch height at 1500, currently set for cube rotation 390
		SCALE(4700),
		RUNG(4700);
		
		private final double height;
		
		private Height(double height) {
			this.height = height;
		}
		
		public double getHeight() {
			return height;
		}
	}
	
	public static final int MAX_HEIGHT = 4700;
	public static final int MIN_HEIGHT = 0;
	public static final double SLOW_HEIGHT = Height.SWITCH.height + 5;
	
	private TalonSRX leftMotor = new TalonSRX(RobotMap.LEFT_ELEVATOR_MOTOR);
//	private BaseMotorController rightMotor = new TalonSRX(RobotMap.RIGHT_ELEVATOR_MOTOR);
	private BaseMotorController rightMotor = new VictorSPX(RobotMap.RIGHT_ELEVATOR_MOTOR);
	
	public Elevator() {
		
		Robot.LOG.addSource("ELEVATOR Left Current", leftMotor, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("ELEVATOR Right Current", rightMotor, f -> "" + ((BaseMotorController)(f)).getOutputCurrent());
		Robot.LOG.addSource("ELEVATOR Left Voltage", leftMotor, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("ELEVATOR Right Voltage", rightMotor, f -> "" + ((BaseMotorController)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("ELEVATOR Encoder Position", this, f -> "" + ((Elevator)(f)).getPosition());
		Robot.LOG.addSource("ELEVATOR Velocity", this, f -> "" + ((Elevator)(f)).getVelocity());
		Robot.LOG.addSource("ELEVATOR Limit Switch State", leftMotor, f -> "" + ((TalonSRX)(f)).getSensorCollection().isRevLimitSwitchClosed());
		Robot.LOG.addSource("ELEVATOR Height", this, f -> "" + ((Elevator)(f)).getHeightPercentage());
		rightMotor.follow(leftMotor);
		rightMotor.setNeutralMode(NeutralMode.Brake);
		rightMotor.configOpenloopRamp(0.2, 0);
		leftMotor.setNeutralMode(NeutralMode.Brake);
		leftMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
		leftMotor.overrideLimitSwitchesEnable(true);
		leftMotor.config_kP(0, 5, 10);
		leftMotor.config_kD(0, 4000, 10);
		leftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		leftMotor.configMotionCruiseVelocity(700, 0);
		leftMotor.configMotionAcceleration(5000, 0);
		leftMotor.configContinuousCurrentLimit(60, 0);
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
	
	public void setPower(double power) {
		leftMotor.set(ControlMode.PercentOutput, power);
	}
	
	public boolean atBottom() {
		return leftMotor.getSensorCollection().isRevLimitSwitchClosed();
	}
	
	public void goTo(double height) {
		leftMotor.set(ControlMode.MotionMagic, height);
	}
	
	protected void initDefaultCommand() {
		// sets the default drive mode to Colson drive
  		setDefaultCommand(new StopElevator());
	}
	
	public double getSlowHeight() {
		return SLOW_HEIGHT;
	}
	
	public double getHeightPercentage() {
		if (getPosition() <= SLOW_HEIGHT) {
				return 0;
		}
			
		return (getPosition() - SLOW_HEIGHT) / (MAX_HEIGHT - SLOW_HEIGHT);
	}

	public void stop() {
		leftMotor.set(ControlMode.PercentOutput, 0.05);
	}

	public void reset() {
		leftMotor.getSensorCollection().setQuadraturePosition(0, 0);
	}
}
