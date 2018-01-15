package org.usfirst.frc.team2363.util.pathplanning.commands;

import java.util.List;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.util.DrivetrainMath;
import org.usfirst.frc.team2363.util.pathplanning.BoTHTrajectory;
import org.usfirst.frc.team2363.util.pathplanning.SrxPathReader;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motion.TrajectoryPoint;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;

public class FollowTrajectory extends Command {

	private final String pathName;
	private int kMinPointsInTalon = 5;
	private double PERIODIC_TIME = .005;  // 5ms

	private volatile MotionProfileStatus rightStatus = new MotionProfileStatus();
	private volatile MotionProfileStatus leftStatus = new MotionProfileStatus();
	
	private TalonSRX leftMaster;
	private TalonSRX rightMaster;

	// Launch a thread for the left master Talon that periodically processes the motion 
	// profile / motor buffer.  Time for periodic set in initialize().
	private class LeftPeriodic implements java.lang.Runnable {
		public void run() {
			leftMaster.processMotionProfileBuffer();
		}
	}
	
	// Launch a thread for the right master Talon that periodically processes the motion 
	// profile / motor buffer.  Time for periodic set in initialize().
	private class RightPeriodic implements java.lang.Runnable {
		public void run() {
			rightMaster.processMotionProfileBuffer();
		}
	}
	
	// Set the thread that the notifier it is associated with.
	private Notifier leftNotifier = new Notifier(new LeftPeriodic());
	private Notifier rightNotifier = new Notifier(new RightPeriodic());

	// Constructor
	public FollowTrajectory(String pathName) {
		requires(Robot.drivetrain);
		this.pathName = pathName;
		
		leftMaster = Robot.drivetrain.getLeft();
		rightMaster = Robot.drivetrain.getRight();
	}

	// Called just before this Command runs the first time
	protected void initialize() {

		// Setup Talons for Motion Profiling
		setUpTalon(rightMaster);
		setUpTalon(leftMaster);

		//  Launch the thread to process the motion profile / motor buffer for each talon. 
		//  Set it to run every PERIODIC_TIME.
		leftNotifier.startPeriodic(PERIODIC_TIME);
		rightNotifier.startPeriodic(PERIODIC_TIME);

		
		// Load the motion profile path file.
    	BoTHTrajectory path = SrxPathReader.importSrxTrajectory(pathName);
    	
    	// FUTURE: pidfSlot can be set to slot 1 if there is ever a different gearing. Corresponds to
    	// slot 0 & 1 on the talon for motion profiles.
		int pidfSlot = 0;  

		// Load the path points into the Talon buffers.
		fillTalonBuffer(leftMaster, SrxPathReader.getTrajectoryPoints(path.getTrajectory().getLeftProfile()), pidfSlot);
		fillTalonBuffer(rightMaster, SrxPathReader.getTrajectoryPoints(path.getTrajectory().getRightProfile()), pidfSlot);
   
		new processStatus(Robot.drivetrain.getLeft(), leftStatus).start();
    	new processStatus(Robot.drivetrain.getRight(), rightStatus).start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		return rightStatus.activePointValid && rightStatus.isLast && leftStatus.activePointValid
				&& leftStatus.isLast;
	}

	// Called once after isFinished returns true
	protected void end() {
		leftNotifier.stop();
		rightNotifier.stop();
		
		resetTalon(leftMaster,ControlMode.PercentOutput, 0);
		resetTalon(rightMaster, ControlMode.PercentOutput, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		leftNotifier.stop();
		rightNotifier.stop();
		
		resetTalon(leftMaster, ControlMode.PercentOutput, 0);
		resetTalon(rightMaster, ControlMode.PercentOutput, 0);
	}	

	// Thread to process each the status of each Talon individually.  NOTE: the rightStatus 
	// & rightStatus are made volatile type so each process can update their status and still
	// have the command see the updated status for the isFinished().
	private class processStatus extends Thread {
    	
    	private final TalonSRX talon;
        private final MotionProfileStatus status;
    	
    	public processStatus(TalonSRX talon, MotionProfileStatus status) {
    		this.talon = talon;
    		this.status = status;
    	}

		@Override
		public void run() {
			/**
			 * this is only either Disable, Enable, or Hold. Since we'd never want one
			 * side to be enabled while the other is disabled, we'll use the same status
			 * for both sides.
			 */
			SetValueMotionProfile setValue = SetValueMotionProfile.Disable;
			
			talon.getMotionProfileStatus(status);

			setValue = SetValueMotionProfile.Disable;
			if (status.isUnderrun) {
				// if either MP has underrun, stop the talon
				setValue = SetValueMotionProfile.Disable;
			} else if (status.btmBufferCnt > kMinPointsInTalon) {
				// if we have enough points in the talon, go.
				setValue = SetValueMotionProfile.Enable;
			} else if (status.activePointValid && status.isLast) {
					// if the talon is on the last point, hold the last point
					setValue = SetValueMotionProfile.Hold;
			}

			talon.set(ControlMode.MotionProfile, setValue.value);
		}
	}
	
	// Set the Talon up for motion profile control
	public void setUpTalon(TalonSRX talon) {
		talon.clearMotionProfileTrajectories();
		talon.changeMotionControlFramePeriod(5);
		talon.set(ControlMode.MotionProfile, SetValueMotionProfile.Disable.value);
	}

	//  Reset & clear motion profiles from the Talon.  Called at the end of a motion profile or when 
	//  interrupted or disabled.
	public void resetTalon(TalonSRX talon, ControlMode controlMode, double setValue) {
		
		talon.clearMotionProfileTrajectories();
		talon.set(ControlMode.PercentOutput, SetValueMotionProfile.Disable.value);
		
	}

	// Push all the profile points to the Talon buffer
	public void fillTalonBuffer(TalonSRX talon, List<TrajectoryPoint> points , int pidfSlot) {
		
		TrajectoryPoint traj_point = new TrajectoryPoint();
		int i = 0;
		
		for (TrajectoryPoint point : points) {
			
			traj_point.position = point.position;
			traj_point.velocity = point.velocity;
			traj_point.timeDur = point.timeDur;
			traj_point.profileSlotSelect0 = pidfSlot;
			
			// When velocityOnly is set to false the motor controller does closed loop control on velocity 
			// & position.   If velocityOnly set to true, the motor controller will only do velocity so NO
			// control loop on position.
			
			traj_point.zeroPos = false;
			// Set zeroPos to true if this is the first point.
			if (i == 0)  traj_point.zeroPos = true; 

			traj_point.isLastPoint = false;
			//  Set isLastPoint to true for the last point. 
			if ((i + 1) == points.size())  traj_point.isLastPoint = true; 
				
			//  Push the point to the Talon buffer.
			talon.pushMotionProfileTrajectory(traj_point);
			i++;
		}
	}
}

