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

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team319.models.SrxMotionProfile;
import org.usfirst.frc.team319.models.SrxTrajectory;

import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;


public class FollowArc extends Command {

	private int kMinPointsInTalon = 5;
	
	private boolean isFinished = false;

	private SrxTrajectory trajectoryToFollow = null;

	private MotionProfileStatus status = new MotionProfileStatus();
	
	private boolean hasPathStarted;

	/**
	 * this is only either Disable, Enable, or Hold. Since we'd never want one
	 * side to be enabled while the other is disabled, we'll use the same status
	 * for both sides.
	 */
	private SetValueMotionProfile setValue = SetValueMotionProfile.Disable;
	
	private class BufferLoader implements java.lang.Runnable {
		private int lastPointSent = 0;
		private TalonSRX talon;
		private SrxMotionProfile prof;
		
		public BufferLoader(TalonSRX talon, SrxMotionProfile prof) {
			this.talon = talon;
			this.prof = prof;
		}
		
		public void run() {
			talon.processMotionProfileBuffer();

			if (lastPointSent >= prof.numPoints) {
				return;
			}

			while(!talon.isMotionProfileTopLevelBufferFull() && lastPointSent < prof.numPoints) {
				TrajectoryPoint point = new TrajectoryPoint();
				/* for each point, fill our structure and pass it to API */
				point.position = prof.points[lastPointSent][0];
				point.velocity = prof.points[lastPointSent][1];
				point.timeDur = TrajectoryDuration.Trajectory_Duration_10ms;
				point.headingDeg = prof.points[lastPointSent][3];
				point.profileSlotSelect0 = 0; 
				point.profileSlotSelect1 = 1;
				point.zeroPos = false;
				if (lastPointSent == 0) {
					point.zeroPos = true; /* set this to true on the first point */
					System.out.println("Loaded first trajectory point");
				}

				point.isLastPoint = false;
				if ((lastPointSent + 1) == prof.numPoints) {
					point.isLastPoint = true; /** set this to true on the last point */
					System.out.println("Loaded last trajectory point");
				}

				talon.pushMotionProfileTrajectory(point);
				lastPointSent++;
				hasPathStarted = true;
			}
		}
	}

	// Runs the runnable
	private Notifier loadLeftBuffer;
	
	public FollowArc(SrxTrajectory trajectoryToFollow) {
		requires(Robot.drivetrain);
		this.trajectoryToFollow = trajectoryToFollow;
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {

		setUpTalon(Robot.drivetrain.getLeft());
		setUpTalon(Robot.drivetrain.getRight());
		
		
		setValue = SetValueMotionProfile.Disable;
		
		Robot.drivetrain.getRight().set(ControlMode.MotionProfileArc, setValue.value);
		Robot.drivetrain.getLeft().follow(Robot.drivetrain.getRight(), FollowerType.AuxOutput1);

		loadLeftBuffer = new Notifier(new BufferLoader(Robot.drivetrain.getRight(), this.trajectoryToFollow.centerProfile));
		
		loadLeftBuffer.startPeriodic(.005);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.getRight().getMotionProfileStatus(status);
		//System.out.println("Bottom buffer count: " + rightStatus.btmBufferCnt);
		//System.out.println("Top buffer count: " + rightStatus.topBufferCnt);
		

		if (status.isUnderrun)
		{
			// if either MP has underrun, stop both
			System.out.println("Motion profile has underrun!");
			setValue = SetValueMotionProfile.Disable;
		}
		else if (status.btmBufferCnt > kMinPointsInTalon)
		{
			// if we have enough points in the talon, go.
			setValue = SetValueMotionProfile.Enable;
		}	
		else if (status.activePointValid
				&& status.isLast)
		{
			// if both profiles are at their last points, hold the last point
			setValue = SetValueMotionProfile.Hold;
		}
		
		Robot.drivetrain.getRight().set(ControlMode.MotionProfileArc, setValue.value);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (!hasPathStarted) {
			return false;
		}
		boolean leftComplete = status.activePointValid && status.isLast;
		boolean trajectoryComplete = leftComplete;
		if (trajectoryComplete) {
			System.out.println("Finished trajectory");
		}
		return trajectoryComplete || isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		loadLeftBuffer.stop();
		resetTalon(Robot.drivetrain.getRight(), ControlMode.PercentOutput, 0);
		resetTalon(Robot.drivetrain.getLeft(), ControlMode.PercentOutput, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		loadLeftBuffer.stop();
		resetTalon(Robot.drivetrain.getRight(), ControlMode.PercentOutput, 0);
		resetTalon(Robot.drivetrain.getLeft(), ControlMode.PercentOutput, 0);
	}	

	// set up the talon for motion profile control
	private void setUpTalon(TalonSRX talon) {
		talon.clearMotionProfileTrajectories();
		talon.changeMotionControlFramePeriod(5);
		talon.clearMotionProfileHasUnderrun(10);
	}

	// set the 	 to the desired controlMode
	// used at the end of the motion profile
	private void resetTalon(TalonSRX talon, ControlMode controlMode, double setValue) {
		talon.clearMotionProfileTrajectories();
		talon.clearMotionProfileHasUnderrun(10);
		talon.set(ControlMode.MotionProfileArc, SetValueMotionProfile.Disable.value);
		talon.set(controlMode, setValue);
	}
}