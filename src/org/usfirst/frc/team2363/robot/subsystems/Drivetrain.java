package org.usfirst.frc.team2363.robot.subsystems;

import static org.usfirst.frc.team2363.robot.RobotMap.FRONT_LEFT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.FRONT_RIGHT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.MIDDLE_LEFT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.MIDDLE_RIGHT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.REAR_LEFT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.REAR_RIGHT_TALON_ID;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.robot.commands.drivetrain.JoystickDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	// Constants
	private static final int ENCODER_TICKS = 120;
	public static final int MAX_RPM = 735;
	
	// Talons
	private TalonSRX frontLeft = new TalonSRX(FRONT_LEFT_TALON_ID);
	private TalonSRX middleLeft = new TalonSRX(MIDDLE_LEFT_TALON_ID);
	private TalonSRX rearLeft = new TalonSRX(REAR_LEFT_TALON_ID);

	private TalonSRX frontRight = new TalonSRX(FRONT_RIGHT_TALON_ID);
	private TalonSRX middleRight = new TalonSRX(MIDDLE_RIGHT_TALON_ID);
	private TalonSRX rearRight = new TalonSRX(REAR_RIGHT_TALON_ID);

	// navX Gryo
	private static AHRS ahrs;
	
	public Drivetrain() {

		Robot.LOG.addSource("LEFT1 Current", frontLeft, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("LEFT2 Current", middleLeft, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("LEFT3 Current", rearLeft, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		
		Robot.LOG.addSource("LEFT1 Voltage", frontLeft, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("LEFT2 Voltage", middleLeft, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("LEFT3 Voltage", rearLeft, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());

		Robot.LOG.addSource("RIGHT1 Current", frontRight, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("RIGHT2 Current", middleRight, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("RIGHT3 Current", rearRight, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		
		Robot.LOG.addSource("RIGHT1 Voltage", frontRight, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("RIGHT2 Voltage", middleRight, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("RIGHT3 Voltage", rearRight, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());

		//  Configure Front Left Master
		frontLeft.selectProfileSlot(0, 0);
		frontLeft.configOpenloopRamp(30, 10);
		frontLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		// Make sure to set Sensor phase appropriately for each master 
		frontLeft.setSensorPhase(true);
		frontLeft.configOpenloopRamp(0.4, 10);
		frontLeft.config_kF(0, 0.20388, 10);
		frontLeft.config_kP(0, 0.05, 10);
		frontLeft.configMotionProfileTrajectoryPeriod(10, 10); //Our profile uses 10 ms timing
		
		/* status 10 provides the trajectory target for motion profile AND motion magic */
		frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);

		// Configure Front Right Master
//		frontRight.changeControlMode(TalonControlMode.PercentVbus);
//		frontRight.setVoltageRampRate(30);
//		frontRight.configEncoderCodesPerRev(DrivetrainMath.ticksPerWheelRotation(ENCODER_TICKS, GEAR_RATIO));	
		
		frontRight.selectProfileSlot(0, 0);
		frontRight.configOpenloopRamp(30, 10);
		frontRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		// Make sure to set Sensor phase appropriately for each master 
		frontRight.setSensorPhase(true); 
		frontRight.configOpenloopRamp(0.4, 10);
		frontRight.config_kF(0, 0.20388, 10);
		frontRight.config_kP(0, 0.05, 10);
		frontRight.configMotionProfileTrajectoryPeriod(10, 10); //Our profile uses 10 ms timing
		/* status 10 provides the trajectory target for motion profile AND motion magic */
		frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);


		middleLeft.set(ControlMode.Follower, frontLeft.getDeviceID());
		middleLeft.setNeutralMode(NeutralMode.Brake);

		middleRight.set(ControlMode.Follower, frontRight.getDeviceID());
		middleRight.setNeutralMode(NeutralMode.Brake);
		
		rearLeft.set(ControlMode.Follower, frontLeft.getDeviceID());
		rearLeft.setNeutralMode(NeutralMode.Brake);
		
		rearRight.set(ControlMode.Follower, frontRight.getDeviceID());
		rearRight.setNeutralMode(NeutralMode.Brake);
		
		// Instantiate the NavMXP Gyro
		try {
			ahrs = new AHRS(SPI.Port.kMXP); 
		} catch (RuntimeException ex ) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}

	public void arcadeDrive(double throttle, double turn, boolean squaredInputs) {
		
		double leftMotorSpeed;
	    double rightMotorSpeed;
	    
//	    Limit used if expected values are greater than 1 or less than -1
//	    throttle = limit(throttle);
//	    turn = limit(turn);

	    if (squaredInputs) {
	      // square the inputs (while preserving the sign) to increase fine control
	      // while permitting full power
	      if (throttle >= 0.0) {
	        throttle = throttle * throttle;
	      } else {
	        throttle = -(throttle * throttle);
	      }
	      if (turn >= 0.0) {
	        turn = turn * turn;
	      } else {
	        turn = -(turn * turn);
	      }
	    }

	    if (throttle > 0.0) {
	      if (turn > 0.0) {
	        leftMotorSpeed = throttle - turn;
	        rightMotorSpeed = Math.max(throttle, turn);
	      } else {
	        leftMotorSpeed = Math.max(throttle, -turn);
	        rightMotorSpeed = throttle + turn;
	      }
	    } else {
	      if (turn > 0.0) {
	        leftMotorSpeed = -Math.max(-throttle, turn);
	        rightMotorSpeed = throttle + turn;
	      } else {
	        leftMotorSpeed = throttle - turn;
	        rightMotorSpeed = -Math.max(-throttle, -turn);
	      }
	    }

	    frontLeft.set(ControlMode.PercentOutput, leftMotorSpeed);
	    frontRight.set(ControlMode.PercentOutput, -rightMotorSpeed);
	}

	public void tankDrive(double left, double right) {
		frontLeft.set(ControlMode.PercentOutput, left);
		frontLeft.set(ControlMode.PercentOutput, right);
	}

	@Override
	protected void initDefaultCommand() {
		// sets the default drive mode to Colson drive
		setDefaultCommand(new JoystickDrive());
	}
	
	public void setUpAutoControl() {
		frontLeft.selectProfileSlot(0, 0);	
		frontLeft.setNeutralMode(NeutralMode.Brake);
		
		frontRight.selectProfileSlot(0, 0);
		frontRight.setNeutralMode(NeutralMode.Brake);
		frontRight.setInverted(true);
	}

	public void setUpManualControl() {
		frontLeft.setNeutralMode(NeutralMode.Brake);
		frontRight.setNeutralMode(NeutralMode.Brake);
		frontRight.setInverted(false);
	}

	public double getAngle() {
		return ahrs.getAngle();
	}

	public void resetAngle() {
		ahrs.zeroYaw();
	}

	public TalonSRX getLeft() {
		return frontLeft;
	}

	public TalonSRX getRight() {
		return frontRight;
	}
	
	public double getLeftError() {
		return frontLeft.getClosedLoopError(0);
	}

	public double getRightError() {
		return frontRight.getClosedLoopError(0);
	}	
	
	public double getRobotSpeedPercent() {
		return getRPM(
				Math.abs((frontLeft.getSelectedSensorVelocity(0) + 
				frontRight.getSelectedSensorVelocity(0)) / 2)) 
				/ MAX_RPM;
	}
	
	private int getRPM(int sensorVelocity) {
		return sensorVelocity * (600 / ENCODER_TICKS);
	}
}
