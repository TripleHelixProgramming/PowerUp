package org.usfirst.frc.team2363.util.pathplanning.commands;

import java.util.List;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.util.DrivetrainMath;
import org.usfirst.frc.team2363.util.pathplanning.BoTHTrajectory;
import org.usfirst.frc.team2363.util.pathplanning.SrxPathReader;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.MotionProfileStatus;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.CANTalon.TrajectoryPoint;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;

public class FollowTrajectory extends Command {

	private final String pathName;
	private int kMinPointsInTalon = 5;
	private double PERIODIC_TIME = .005;  // 5ms

	private volatile MotionProfileStatus rightStatus = new CANTalon.MotionProfileStatus();
	private volatile MotionProfileStatus leftStatus = new CANTalon.MotionProfileStatus();
	
	private CANTalon leftMaster;
	private CANTalon rightMaster;

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

		return rightStatus.activePointValid && rightStatus.activePoint.isLastPoint && leftStatus.activePointValid
				&& leftStatus.activePoint.isLastPoint;
	}

	// Called once after isFinished returns true
	protected void end() {
		leftNotifier.stop();
		rightNotifier.stop();
		
		resetTalon(leftMaster, TalonControlMode.PercentVbus, 0);
		resetTalon(rightMaster, TalonControlMode.PercentVbus, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		leftNotifier.stop();
		rightNotifier.stop();
		
		resetTalon(leftMaster, TalonControlMode.PercentVbus, 0);
		resetTalon(rightMaster, TalonControlMode.PercentVbus, 0);
	}	

	// Thread to process each the status of each Talon individually.  NOTE: the rightStatus 
	// & rightStatus are made volatile type so each process can update their status and still
	// have the command see the updated status for the isFinished().
	private class processStatus extends Thread {
    	
    	private final CANTalon talon;
        private final MotionProfileStatus status;
    	
    	public processStatus(CANTalon talon, MotionProfileStatus status) {
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
			CANTalon.SetValueMotionProfile setValue = CANTalon.SetValueMotionProfile.Disable;
			
			talon.getMotionProfileStatus(status);

			setValue = CANTalon.SetValueMotionProfile.Disable;
			if (status.isUnderrun) {
				// if either MP has underrun, stop the talon
				setValue = CANTalon.SetValueMotionProfile.Disable;
			} else if (status.btmBufferCnt > kMinPointsInTalon) {
				// if we have enough points in the talon, go.
				setValue = CANTalon.SetValueMotionProfile.Enable;
			} else if (status.activePointValid && status.activePoint.isLastPoint) {
					// if the talon is on the last point, hold the last point
					setValue = CANTalon.SetValueMotionProfile.Hold;
			}

			talon.set(setValue.value);
		}
	}
	
	// Set the Talon up for motion profile control
	public void setUpTalon(CANTalon talon) {
		
		// Make sure we have the full peak output voltage range
		talon.configPeakOutputVoltage(12.0f, -12.0f);
		talon.changeControlMode(TalonControlMode.MotionProfile);
		talon.clearMotionProfileTrajectories();
		talon.changeMotionControlFramePeriod(5);
		talon.set(CANTalon.SetValueMotionProfile.Disable.value);
	}

	//  Reset & clear motion profiles from the Talon.  Called at the end of a motion profile or when 
	//  interrupted or disabled.
	public void resetTalon(CANTalon talon, TalonControlMode controlMode, double setValue) {
		
		talon.clearMotionProfileTrajectories();
		talon.set(CANTalon.SetValueMotionProfile.Disable.value);
		
		talon.changeControlMode(controlMode);
		talon.setVoltageRampRate(30);
		talon.setF(0.20388);
		talon.setP(0.05);
		talon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		talon.configEncoderCodesPerRev(DrivetrainMath.ticksPerWheelRotation(4096, 1));

		talon.set(setValue);
	}

	// Push all the profile points to the Talon buffer
	public void fillTalonBuffer(CANTalon talon, List<TrajectoryPoint> points , int pidfSlot) {
		
		CANTalon.TrajectoryPoint traj_point = new CANTalon.TrajectoryPoint();
		int i = 0;
		
		for (TrajectoryPoint point : points) {
			
			traj_point.position = point.position;
			traj_point.velocity = point.velocity;
			traj_point.timeDurMs = point.timeDurMs;
			traj_point.profileSlotSelect = pidfSlot;
			
			// When velocityOnly is set to false the motor controller does closed loop control on velocity 
			// & position.   If velocityOnly set to true, the motor controller will only do velocity so NO
			// control loop on position.
			traj_point.velocityOnly = false;
			
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

