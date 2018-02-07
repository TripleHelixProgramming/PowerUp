// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team319.robot.commands;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.usfirst.frc.team319.utils.SrxTrajectoryImporter;

import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team319.models.SrxMotionProfile;
import org.usfirst.frc.team319.models.SrxTrajectory;


public class FollowTrajectory extends Command {

	private String trajectoryName = "";
	private int kMinPointsInTalon = 5;
	
	private boolean isFinished = false;

	private SrxTrajectory trajectoryToFollow = null;
	private SrxTrajectoryImporter importer = new SrxTrajectoryImporter("/home/lvuser/Autos");

	private MotionProfileStatus rightStatus = new MotionProfileStatus();
	private MotionProfileStatus leftStatus = new MotionProfileStatus();
	
	private final boolean reversed;

	/**
	 * this is only either Disable, Enable, or Hold. Since we'd never want one
	 * side to be enabled while the other is disabled, we'll use the same status
	 * for both sides.
	 */
	private SetValueMotionProfile setValue = SetValueMotionProfile.Disable;

	// periodically tells the SRXs to do the thing
	private class PeriodicRunnable implements java.lang.Runnable {
		public void run() {
			
			Robot.drivetrain.getLeft().processMotionProfileBuffer();
			Robot.drivetrain.getRight().processMotionProfileBuffer();
		}
	}
	
	private class BufferLoader implements java.lang.Runnable {
		private int lastPointSent = 0;
		private TalonSRX talon;
		private SrxMotionProfile prof;
		private int pidfSlot;
		
		public BufferLoader(TalonSRX talon, SrxMotionProfile prof, int pidfSlot) {
			this.talon = talon;
			this.prof = prof;
			this.pidfSlot = pidfSlot;
		}
		
		public void run() {
			if (lastPointSent >= prof.numPoints) {
				return;
			}
			System.out.println("filling talon buffer");
			TrajectoryPoint point = new TrajectoryPoint();

			while (!talon.isMotionProfileTopLevelBufferFull()) {
				/* for each point, fill our structure and pass it to API */
				point.position = prof.points[lastPointSent][0];
				point.velocity = prof.points[lastPointSent][1];
				point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
				point.profileSlotSelect0 = pidfSlot; 
				point.profileSlotSelect1 = pidfSlot;
				point.zeroPos = false;
				if (lastPointSent == 0)
					point.zeroPos = true; /* set this to true on the first point */

				point.isLastPoint = false;
				if ((lastPointSent + 1) == prof.numPoints)
					point.isLastPoint = true; /*
												 * set this to true on the last point
												 */

				talon.pushMotionProfileTrajectory(point);
				lastPointSent++;
			}
		}
	}

	// Runs the runnable
	private Notifier SrxNotifier = new Notifier(new PeriodicRunnable());
	private Notifier loadLeftBuffer;
	private Notifier loadRightBuffer;

	// constructor
	public FollowTrajectory(String trajectoryName) {
		requires(Robot.drivetrain);
		this.trajectoryName = trajectoryName;
		reversed = false;
	}
	
	public FollowTrajectory(SrxTrajectory trajectoryToFollow) {
		requires(Robot.drivetrain);
		this.trajectoryToFollow = trajectoryToFollow;
		reversed = false;
	}
	
	public FollowTrajectory(SrxTrajectory trajectoryToFollow, boolean reversed) {
		requires(Robot.drivetrain);
		this.trajectoryToFollow = trajectoryToFollow;
		this.reversed = reversed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

		setUpTalon(Robot.drivetrain.getLeft());
		setUpTalon(Robot.drivetrain.getRight());
		
		
		setValue = SetValueMotionProfile.Disable;
		
		Robot.drivetrain.getLeft().set(ControlMode.MotionProfile, setValue.value);
		Robot.drivetrain.getRight().set(ControlMode.MotionProfile, setValue.value);

		if(trajectoryToFollow == null) {
			
			try 
			{
				this.trajectoryToFollow = importer.importSrxTrajectory(trajectoryName);
			} 
			catch (IOException | ParseException e) {
				System.out.println("Failed to import trajectory.");
				e.printStackTrace();
				isFinished = true;
				return;
			}
		}
		
		int pidfSlot = 0;
		
		if (reversed) {
			loadLeftBuffer = new Notifier(new BufferLoader(Robot.drivetrain.getRight(), this.trajectoryToFollow.leftProfile, pidfSlot));
			loadRightBuffer = new Notifier(new BufferLoader(Robot.drivetrain.getLeft(), this.trajectoryToFollow.rightProfile, pidfSlot));
		} else {
			loadLeftBuffer = new Notifier(new BufferLoader(Robot.drivetrain.getRight(), this.trajectoryToFollow.rightProfile, pidfSlot));
			loadRightBuffer = new Notifier(new BufferLoader(Robot.drivetrain.getLeft(), this.trajectoryToFollow.leftProfile, pidfSlot));
		}
		
		SrxNotifier.startPeriodic(.005);
		loadLeftBuffer.startPeriodic(.005);
		loadRightBuffer.startPeriodic(.005);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		Robot.drivetrain.getRight().getMotionProfileStatus(rightStatus);
		Robot.drivetrain.getLeft().getMotionProfileStatus(leftStatus);
		//System.out.println("Bottom buffer count: " + rightStatus.btmBufferCnt);
		//System.out.println("Top buffer count: " + rightStatus.topBufferCnt);
		

		if (rightStatus.isUnderrun || leftStatus.isUnderrun)
		{
			// if either MP has underrun, stop both
			System.out.println("Motion profile has underrun!");
			setValue = SetValueMotionProfile.Disable;
		}
		else if (rightStatus.btmBufferCnt > kMinPointsInTalon && leftStatus.btmBufferCnt > kMinPointsInTalon)
		{
			// if we have enough points in the talon, go.
			setValue = SetValueMotionProfile.Enable;
		}	
		else if (rightStatus.activePointValid && rightStatus.isLast && leftStatus.activePointValid
				&& leftStatus.isLast)
		{
			// if both profiles are at their last points, hold the last point
			setValue = SetValueMotionProfile.Hold;
		}
		
		Robot.drivetrain.getLeft().set(ControlMode.MotionProfile, setValue.value);
		Robot.drivetrain.getRight().set(ControlMode.MotionProfile, setValue.value);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		boolean leftComplete = leftStatus.activePointValid && leftStatus.isLast;
		boolean rightComplete = rightStatus.activePointValid && rightStatus.isLast;
		boolean trajectoryComplete = leftComplete && rightComplete;
		return trajectoryComplete || isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		SrxNotifier.stop();
		loadLeftBuffer.stop();
		loadRightBuffer.stop();
		resetTalon(Robot.drivetrain.getRight(), ControlMode.PercentOutput, 0);
		resetTalon(Robot.drivetrain.getLeft(), ControlMode.PercentOutput, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		SrxNotifier.stop();
		loadLeftBuffer.stop();
		loadRightBuffer.stop();
		resetTalon(Robot.drivetrain.getRight(), ControlMode.PercentOutput, 0);
		resetTalon(Robot.drivetrain.getLeft(), ControlMode.PercentOutput, 0);
	}	

	// set up the talon for motion profile control
	private void setUpTalon(TalonSRX talon) {
		talon.clearMotionProfileTrajectories();
		talon.changeMotionControlFramePeriod(5);
	}

	// set the 	 to the desired controlMode
	// used at the end of the motion profile
	private void resetTalon(TalonSRX talon, ControlMode controlMode, double setValue) {
		talon.clearMotionProfileTrajectories();
		talon.set(ControlMode.MotionProfile, SetValueMotionProfile.Disable.value);
		talon.set(controlMode, setValue);
	}
}
