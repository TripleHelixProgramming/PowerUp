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
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {

	//Drivetrain geometry constants
	//public static final int MAX_RPM = 3900;
	public static final int DT_ENCODER_TICKS_PER_REV = 480;
		//4 edges * 120 count quadrature encoder
		//units of rate (ticks per encoder revolution)
	public static final int MAX_DRIVESIDE_VELOCITY = 144;
		//adjusted speed from JVN calculator
		//units of velocity (in/s)
	public static final int DT_HALF_TRACK_WIDTH = 13;
		//distance between the robot centerline and the midpoint of the DT contact patches
		//units of length (in)
	public static final double DT_WHEEL_DIA = 4.0;
		//diameter of wheel
		//units of length (in)
	public static final double DT_ENCODER_GEAR_RATIO = 42.0 / 48;
		//gear ratio between encoder shaft and wheel axle
		//unitless
	public static final double ticks_per_100ms = (DT_ENCODER_TICKS_PER_REV / (DT_WHEEL_DIA * Math.PI * DT_ENCODER_GEAR_RATIO * 10.0));
		//factor to convert a linear velocity in in/s to units of counts per 100 ms
		//DT_ENCODER_TICKS_PER_REV - units of rate (ticks per encoder revolution)
		//DT_WHEEL_DIA - diameter of wheel - in
		//DT_ENCODER_GEAR_RATIO - gear ratio between encoder shaft and wheel axle - unitless
		//ticks_per_100ms - factor - (counts * s) / (in * 100 ms)
	
	//PID control constants
	private static final int kSlotIdx = 0;
	private static final int kPIDLoopIdx = 0;
	private static final int kTimeoutMs = 10;
	
	//PID gains
	private static final double kF = 1.0;
	private static final double kP = 0.2;
	private static final double kD = 0.0;
	
	//Talon configuration
	private TalonSRX frontLeft = new TalonSRX(FRONT_LEFT_TALON_ID);
	private BaseMotorController middleLeft = new TalonSRX(MIDDLE_LEFT_TALON_ID);
	private BaseMotorController rearLeft = new TalonSRX(REAR_LEFT_TALON_ID);
	//private BaseMotorController middleLeft = new VictorSPX(MIDDLE_LEFT_TALON_ID);
	//private BaseMotorController rearLeft = new VictorSPX(REAR_LEFT_TALON_ID);	
	private TalonSRX frontRight = new TalonSRX(FRONT_RIGHT_TALON_ID);
	private BaseMotorController middleRight = new TalonSRX(MIDDLE_RIGHT_TALON_ID);
	private BaseMotorController rearRight = new TalonSRX(REAR_RIGHT_TALON_ID);
	//private BaseMotorController middleRight = new VictorSPX(MIDDLE_RIGHT_TALON_ID);
	//private BaseMotorController rearRight = new VictorSPX(REAR_RIGHT_TALON_ID);
	
	//navX Gryo
	//private static AHRS ahrs;
	
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

		//master controllers - initial config
		frontLeft.selectProfileSlot(kSlotIdx, kPIDLoopIdx);
		//frontLeft.configOpenloopRamp(0.4, kTimeoutMs);
		frontLeft.configClosedloopRamp(0.1, kTimeoutMs);
		frontRight.selectProfileSlot(kSlotIdx, kPIDLoopIdx);
		//frontRight.configOpenloopRamp(0.4, kTimeoutMs);
		frontRight.configClosedloopRamp(0.1, kTimeoutMs);

		//master controllers - set the feedback device
		//Make sure to set Sensor phase appropriately for each master
		frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, kPIDLoopIdx, kTimeoutMs); 
		frontLeft.setSensorPhase(true);
		frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, kPIDLoopIdx, kTimeoutMs);
		frontRight.setSensorPhase(true); 
		
		//master controllers - set peak and nominal outputs
		frontLeft.configNominalOutputForward(0, kTimeoutMs);
		frontLeft.configNominalOutputReverse(0, kTimeoutMs);		
		frontLeft.configPeakOutputForward(1, kTimeoutMs);	
		frontLeft.configPeakOutputReverse(-1, kTimeoutMs);
		frontLeft.configNeutralDeadband(0.04, kTimeoutMs);
		frontRight.configNominalOutputForward(0, kTimeoutMs);
		frontRight.configNominalOutputReverse(0, kTimeoutMs);		
		frontRight.configPeakOutputForward(1, kTimeoutMs);	
		frontRight.configPeakOutputReverse(-1, kTimeoutMs);
		frontRight.configNeutralDeadband(0.04, kTimeoutMs);
		
		//master controllers - set closed loop gains
		frontLeft.config_kF(kPIDLoopIdx, kF, kTimeoutMs);
		frontLeft.config_kP(kPIDLoopIdx, kP, kTimeoutMs);
		frontLeft.config_kD(kPIDLoopIdx, kD, kTimeoutMs);
		frontRight.config_kF(kPIDLoopIdx, kF, kTimeoutMs);
		frontRight.config_kP(kPIDLoopIdx, kP, kTimeoutMs);
		frontRight.config_kD(kPIDLoopIdx, kD, kTimeoutMs);
		
		//master controllers - set motion profile trajectory period
		frontLeft.configMotionProfileTrajectoryPeriod(0, kTimeoutMs);
		frontRight.configMotionProfileTrajectoryPeriod(0, kTimeoutMs);
		
		//master controllers - set current limit
		frontLeft.configContinuousCurrentLimit(40, 0);
		frontLeft.configPeakCurrentLimit(60, 0);
		frontLeft.configPeakCurrentDuration(100, 0);
		frontLeft.enableCurrentLimit(true);
		frontRight.configContinuousCurrentLimit(40, 0);
		frontRight.configPeakCurrentLimit(60, 0);
		frontRight.configPeakCurrentDuration(100, 0);
		frontRight.enableCurrentLimit(true);
		
		//not used
		//frontRight.changeControlMode(TalonControlMode.PercentVbus);
		//frontRight.setVoltageRampRate(30);
		//frontRight.configEncoderCodesPerRev(DrivetrainMath.ticksPerWheelRotation(ENCODER_TICKS, GEAR_RATIO));	
		
		//status 10 provides the trajectory target for motion profile AND motion magic
		//frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, kTimeoutMs);
		//frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, kTimeoutMs);
		
		//invert all controllers on left side
		frontLeft.setInverted(true);
		middleLeft.setInverted(true);
		rearLeft.setInverted(true);

		//set all other controllers to follow their masters
		middleLeft.follow(frontLeft);
		rearLeft.follow(frontLeft);
		middleRight.follow(frontRight);
		rearRight.follow(frontRight);

		//set all follower controllers to brake mode
		middleLeft.setNeutralMode(NeutralMode.Brake);
		rearLeft.setNeutralMode(NeutralMode.Brake);
		middleRight.setNeutralMode(NeutralMode.Brake);
		rearRight.setNeutralMode(NeutralMode.Brake);
		
	}
	
	public void periodic() {
		SmartDashboard.putNumber("Drivetrain Left RPM", getRPM(frontLeft.getSelectedSensorVelocity(0)));
		SmartDashboard.putNumber("Drivetrain Right RPM", getRPM(frontRight.getSelectedSensorVelocity(0)));
		SmartDashboard.putNumber("Drivetrain Left Error", getLeftError());
		SmartDashboard.putNumber("Drivetrain Right Error", getRightError());
//		SmartDashboard.putNumber("Drivetrain Left Trajectory", frontLeft.getActiveTrajectoryPosition());
//		SmartDashboard.putNumber("Drivetrain Right Trajectory", frontRight.getActiveTrajectoryPosition());
	}

	/* not used
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
	*/
	
	public void drive(double left_unitsPer100ms, double right_unitsPer100ms) {
		frontLeft.set(ControlMode.Velocity, left_unitsPer100ms);
		frontRight.set(ControlMode.Velocity, right_unitsPer100ms);
	}
	
	/* not used
	public void tankDrive(double left, double right) {
		frontLeft.set(ControlMode.PercentOutput, left);
		frontRight.set(ControlMode.PercentOutput, right);
	}
	*/

	@Override
	protected void initDefaultCommand() {
		// sets the default drive mode to Colson drive
		setDefaultCommand(new JoystickDrive());
	}

	/* deleted gyro
	public double getAngle() {
		return ahrs.getAngle();
	}

	public void resetAngle() {
		ahrs.zeroYaw();
	}
	*/

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
	
	/* not used	
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
	*/
	
	private int getRPM(int sensorVelocity) {
		return sensorVelocity * (600 / DT_ENCODER_TICKS_PER_REV);
	}
	
	/* removing adjust for height
	public void adjustForHeight(double heightPercentage) {
		frontRight.configOpenloopRamp(0.5 + (0.3 * heightPercentage), 0);//0.4, 0.6
		frontLeft.configOpenloopRamp(0.5 + (0.3 * heightPercentage), 0);
	}
	*/
}
