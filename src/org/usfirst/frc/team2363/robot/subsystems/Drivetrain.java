package org.usfirst.frc.team2363.robot.subsystems;

import static org.usfirst.frc.team2363.robot.RobotMap.FRONT_LEFT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.FRONT_RIGHT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.MIDDLE_LEFT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.MIDDLE_RIGHT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.REAR_LEFT_TALON_ID;
import static org.usfirst.frc.team2363.robot.RobotMap.REAR_RIGHT_TALON_ID;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.drivetrain.JoystickDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {

	// Constants
	private static final int ENCODER_TICKS = 480;
	public static final int MAX_RPM = 3900;
	
	// Talons
	private TalonSRX frontLeft = new TalonSRX(FRONT_LEFT_TALON_ID);
//	private BaseMotorController middleLeft = new TalonSRX(MIDDLE_LEFT_TALON_ID);
//	private BaseMotorController rearLeft = new TalonSRX(REAR_LEFT_TALON_ID);
	private BaseMotorController middleLeft = new VictorSPX(MIDDLE_LEFT_TALON_ID);
	private BaseMotorController rearLeft = new VictorSPX(REAR_LEFT_TALON_ID);
	
	private TalonSRX frontRight = new TalonSRX(FRONT_RIGHT_TALON_ID);
//	private BaseMotorController middleRight = new TalonSRX(MIDDLE_RIGHT_TALON_ID);
//	private BaseMotorController rearRight = new TalonSRX(REAR_RIGHT_TALON_ID);
	private BaseMotorController middleRight = new VictorSPX(MIDDLE_RIGHT_TALON_ID);
	private BaseMotorController rearRight = new VictorSPX(REAR_RIGHT_TALON_ID);

	// navX Gryo
	private PigeonIMU pigeon = new PigeonIMU(RobotMap.PIGEON_ID);
	
	public Drivetrain() {

		Robot.LOG.addSource("DRIVETRAIN LEFT1 Current", frontLeft, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("DRIVETRAIN LEFT2 Current", middleLeft, f -> "" + ((BaseMotorController)(f)).getOutputCurrent());
		Robot.LOG.addSource("DRIVETRAIN LEFT3 Current", rearLeft, f -> "" + ((BaseMotorController)(f)).getOutputCurrent());
		
		Robot.LOG.addSource("Left Drivetrain Error", frontLeft, f -> "" + ((TalonSRX)(f)).getClosedLoopError(0));
		Robot.LOG.addSource("Right Drivetrain Error", frontRight, f -> "" + ((TalonSRX)(f)).getClosedLoopError(0));
		
		Robot.LOG.addSource("DRIVETRAIN LEFT1 Voltage", frontLeft, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("DRIVETRAIN LEFT2 Voltage", middleLeft, f -> "" + ((BaseMotorController)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("DRIVETRAIN LEFT3 Voltage", rearLeft, f -> "" + ((BaseMotorController)(f)).getMotorOutputVoltage());

		Robot.LOG.addSource("DRIVETRAIN RIGHT1 Current", frontRight, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("DRIVETRAIN RIGHT2 Current", middleRight, f -> "" + ((BaseMotorController)(f)).getOutputCurrent());
		Robot.LOG.addSource("DRIVETRAIN RIGHT3 Current", rearRight, f -> "" + ((BaseMotorController)(f)).getOutputCurrent());
		
		Robot.LOG.addSource("DRIVETRAIN RIGHT1 Voltage", frontRight, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("DRIVETRAIN RIGHT2 Voltage", middleRight, f -> "" + ((BaseMotorController)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("DRIVETRAIN RIGHT3 Voltage", rearRight, f -> "" + ((BaseMotorController)(f)).getMotorOutputVoltage());

		Robot.LOG.addSource("DRIVETRAIN RightRPM", frontRight, f -> "" + getRPM(((TalonSRX)(f)).getSelectedSensorVelocity(0)));
		Robot.LOG.addSource("DRIVETRAIN LeftRPM", frontLeft, f -> "" + getRPM(((TalonSRX)(f)).getSelectedSensorVelocity(0)));

		//  Configure Front Left Master
		frontLeft.selectProfileSlot(0, 0);
		frontLeft.configOpenloopRamp(0.4, 10);
		frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		// Make sure to set Sensor phase appropriately for each master 
		frontLeft.setSensorPhase(true);
		frontLeft.config_kF(0, 2, 10);
//		frontLeft.config_kP(0, 7.25, 10);//original p values
		frontLeft.config_kP(0, 43.0, 10);
		frontLeft.config_kD(0, 75.0, 10);
		
		frontLeft.setInverted(true);
		middleLeft.setInverted(true);
		rearLeft.setInverted(true);
		
		/* status 10 provid[]\
		 * trajectory target for motion profile AND motion magic */
		frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);

		// Configure Front Right Master
//		frontRight.changeControlMode(TalonControlMode.PercentVbus);
//		frontRight.setVoltageRampRate(30);
//		frontRight.configEncoderCodesPerRev(DrivetrainMath.ticksPerWheelRotation(ENCODER_TICKS, GEAR_RATIO));	
		
		frontRight.selectProfileSlot(0, 0);
		frontRight.configOpenloopRamp(0.4, 10);
		frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		// Make sure to set Sensor phase appropriately for each master 
		frontRight.setSensorPhase(true); 
		frontRight.config_kF(0, 2, 10);
//		frontRight.config_kP(0, 7.25, 10);//original p values
		frontRight.config_kP(0, 43.0, 10);
		frontRight.config_kD(0, 75.0, 10);
		/* status 10 provides the trajectory target for motion profile AND motion magic */
		frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);


		middleLeft.follow(frontLeft);
		middleLeft.setNeutralMode(NeutralMode.Brake);

		middleRight.follow(frontRight);
		middleRight.setNeutralMode(NeutralMode.Brake);
		
		rearLeft.follow(frontLeft);
		rearLeft.setNeutralMode(NeutralMode.Brake);
		
		rearRight.follow(frontRight);
		rearRight.setNeutralMode(NeutralMode.Brake);
		
		frontLeft.configMotionProfileTrajectoryPeriod(0, 10);
		frontRight.configMotionProfileTrajectoryPeriod(0, 10);
		
		frontLeft.configPeakCurrentLimit(40, 0);
		frontLeft.configPeakCurrentDuration(1000, 0);
		frontRight.configPeakCurrentLimit(40, 0);
		frontRight.configPeakCurrentDuration(1000, 0);
		
		/* Remote 0 will be the other side's Talon */
		frontRight.configRemoteFeedbackFilter(frontLeft.getDeviceID(),
				RemoteSensorSource.TalonSRX_SelectedSensor, 0, 0);
		/* Remote 1 will be a pigeon */
		frontRight.configRemoteFeedbackFilter(pigeon.getDeviceID(),
				RemoteSensorSource.Pigeon_Yaw, 1, 0);
		
		frontRight.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.RemoteSensor0, 0);
		frontRight.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.QuadEncoder, 0);
		/* select sum for distance(0), different for turn(1) */
		
		frontRight.configSelectedFeedbackSensor(FeedbackDevice.SensorSum, 0, 0);
		frontRight.configSelectedFeedbackSensor(FeedbackDevice.RemoteSensor1, 1, 0);

		frontRight.configSelectedFeedbackCoefficient(0.5, 0, 0); //Coefficient for Distance
		frontRight.configSelectedFeedbackCoefficient(3600 / 8192, 1, 0); //Coefficient for Pigeon to convert to 360
		
		frontLeft.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, 0);
		frontRight.configAuxPIDPolarity(false, 0);
	}
	
	public void periodic() {
		SmartDashboard.putNumber("Drivetrain Left RPM", getRPM(frontLeft.getSelectedSensorVelocity(0)));
		SmartDashboard.putNumber("Drivetrain Right RPM", getRPM(frontRight.getSelectedSensorVelocity(0)));
		SmartDashboard.putNumber("Drivetrain Left Error", getLeftError());
		SmartDashboard.putNumber("Drivetrain Right Error", getRightError());
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

	    frontLeft.set(ControlMode.PercentOutput, -leftMotorSpeed);
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
	
	public double getAngle() {
		double[] ypr = new double[3];
		pigeon.getYawPitchRoll(ypr);
		return ypr[0];
	}

	public void resetAngle() {
		pigeon.setYaw(0, 0);
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
		if(frontLeft.getSelectedSensorVelocity(0) * frontRight.getSelectedSensorVelocity(0) > 0) {
			return 0;
		} else {
			return getRPM(
					Math.abs((frontLeft.getSelectedSensorVelocity(0) + 
					frontRight.getSelectedSensorVelocity(0)) / 2)) 
					/ MAX_RPM;	
		}	
	}
	
	private int getRPM(int sensorVelocity) {
		return sensorVelocity * (600 / ENCODER_TICKS);
	}
	
	public void adjustForHeight(double heightPercentage) {
		frontRight.configOpenloopRamp(0.5 + (0.3 * heightPercentage), 0);//0.4, 0.6
		frontLeft.configOpenloopRamp(0.5 + (0.3 * heightPercentage), 0);
	}
}
