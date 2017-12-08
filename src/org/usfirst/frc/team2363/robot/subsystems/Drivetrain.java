package org.usfirst.frc.team2363.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.robot.commands.drivetrain.TractionDrive;
import org.usfirst.frc.team2363.util.DrivetrainMath;

public class Drivetrain extends Subsystem {

	// Constants
	private static final int ENCODER_TICKS = 4096;
	private static final double GEAR_RATIO = 1;
	
	// Talons
	private CANTalon frontLeft = new CANTalon(FRONT_LEFT_TALON_ID);
	private CANTalon middleLeft = new CANTalon(MIDDLE_LEFT_TALON_ID);
	private CANTalon rearLeft = new CANTalon(REAR_LEFT_TALON_ID);

	private CANTalon frontRight = new CANTalon(FRONT_RIGHT_TALON_ID);
	private CANTalon middleRight = new CANTalon(MIDDLE_RIGHT_TALON_ID);
	private CANTalon rearRight = new CANTalon(REAR_RIGHT_TALON_ID);

	// Solenoids
	private Solenoid omni = new Solenoid(PCM_0, DROP_DOWN);

	// navX Gryo
	private static AHRS ahrs;

	// Drivetrain
	private RobotDrive robotDrive = new RobotDrive(frontLeft, frontRight);


	public Drivetrain() {

		Robot.LOG.addSource("LEFT1 Current", frontLeft, f -> "" + ((CANTalon)(f)).getOutputCurrent());
		Robot.LOG.addSource("LEFT2 Current", middleLeft, f -> "" + ((CANTalon)(f)).getOutputCurrent());
		Robot.LOG.addSource("LEFT3 Current", rearLeft, f -> "" + ((CANTalon)(f)).getOutputCurrent());
		
		Robot.LOG.addSource("LEFT1 Voltage", frontLeft, f -> "" + ((CANTalon)(f)).getOutputVoltage());
		Robot.LOG.addSource("LEFT2 Voltage", middleLeft, f -> "" + ((CANTalon)(f)).getOutputVoltage());
		Robot.LOG.addSource("LEFT3 Voltage", rearLeft, f -> "" + ((CANTalon)(f)).getOutputVoltage());

		Robot.LOG.addSource("RIGHT1 Current", frontRight, f -> "" + ((CANTalon)(f)).getOutputCurrent());
		Robot.LOG.addSource("RIGHT2 Current", middleRight, f -> "" + ((CANTalon)(f)).getOutputCurrent());
		Robot.LOG.addSource("RIGHT3 Current", rearRight, f -> "" + ((CANTalon)(f)).getOutputCurrent());
		
		Robot.LOG.addSource("RIGHT1 Voltage", frontRight, f -> "" + ((CANTalon)(f)).getOutputVoltage());
		Robot.LOG.addSource("RIGHT2 Voltage", middleRight, f -> "" + ((CANTalon)(f)).getOutputVoltage());
		Robot.LOG.addSource("RIGHT3 Voltage", rearRight, f -> "" + ((CANTalon)(f)).getOutputVoltage());
		
		Robot.LOG.addSource("Left Drivetrain Speed", frontLeft, f -> "" + ((CANTalon)(f)).getSpeed());
		Robot.LOG.addSource("Right Drivetrain Speed", frontRight, f -> "" + ((CANTalon)(f)).getSpeed());
		
		Robot.LOG.addSource("Drop Downs", omni, f -> "" + ((Solenoid)f).get());

		robotDrive.setSafetyEnabled(false);

		frontLeft.setProfile(0);
		frontLeft.changeControlMode(TalonControlMode.PercentVbus);
		frontLeft.setVoltageRampRate(30);
		frontLeft.setF(0.20388);
		frontLeft.setP(0.05);
		frontLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		frontLeft.configEncoderCodesPerRev(DrivetrainMath.ticksPerWheelRotation(ENCODER_TICKS, GEAR_RATIO));

		frontRight.setProfile(0);
		frontRight.changeControlMode(TalonControlMode.PercentVbus);
		frontRight.setVoltageRampRate(30);
		frontRight.setF(0.20388);
		frontRight.setP(0.05);
		frontRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		frontRight.configEncoderCodesPerRev(DrivetrainMath.ticksPerWheelRotation(ENCODER_TICKS, GEAR_RATIO));
		frontRight.reverseSensor(true);

		middleLeft.changeControlMode(TalonControlMode.Follower);
		middleLeft.set(frontLeft.getDeviceID());
		middleLeft.enableBrakeMode(true);

		middleRight.changeControlMode(TalonControlMode.Follower);
		middleRight.set(frontRight.getDeviceID());
		middleRight.enableBrakeMode(true);

		rearLeft.changeControlMode(TalonControlMode.Follower);
		rearLeft.set(frontLeft.getDeviceID());
		rearLeft.enableBrakeMode(true);

		rearRight.changeControlMode(TalonControlMode.Follower);
		rearRight.set(frontRight.getDeviceID());
		rearRight.enableBrakeMode(true);
		
		// Instantiate the NavMXP Gyro
		try {
			ahrs = new AHRS(SPI.Port.kMXP); 
		} catch (RuntimeException ex ) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}

	public void arcadeDrive(double throttle, double turn) {
		robotDrive.arcadeDrive(throttle, turn, false);
	}

	public void tankDrive(double left, double right) {
		robotDrive.tankDrive(left, right, false);
	}

	public void deployOmnis() {
		// deploy front & back Omni wheels
		omni.set(true);
	}

	public void retractOmnis() {
		// retract front & back Omni wheels
		omni.set(false);
	}

	public void driveMotors(double lSpeed, double rSpeed) {
		frontLeft.set(lSpeed);
		frontRight.set(rSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		// sets the default drive mode to Colson drive
		setDefaultCommand(new TractionDrive());
	}

	public void setUpAutoControl() {
		frontLeft.setProfile(0);		
		frontLeft.enableBrakeMode(true);
		
		frontRight.setProfile(0);
		frontRight.enableBrakeMode(true);
		frontRight.reverseOutput(true);
	}

	public void setUpManualControl() {
		frontLeft.changeControlMode(TalonControlMode.PercentVbus);
		frontRight.changeControlMode(TalonControlMode.PercentVbus);
		frontLeft.enableBrakeMode(true);
		frontRight.enableBrakeMode(true);
		frontRight.reverseOutput(false);
	}

	public void setSpeeds(double leftSpeed, double rightSpeed) {
		frontLeft.set(-leftSpeed);
		frontRight.set(rightSpeed);
	}

	public double getAngle() {
		return ahrs.getAngle();
	}

	public void resetAngle() {
		ahrs.zeroYaw();
	}

	public CANTalon getLeft() {
		return frontLeft;
	}

	public CANTalon getRight() {
		return frontRight;
	}

	public boolean getOmniState() {
		return omni.get();
	}

	public double getLeftError() {
		return frontLeft.getError();
	}

	public double getRightError() {
		return frontRight.getError();
	}
}
