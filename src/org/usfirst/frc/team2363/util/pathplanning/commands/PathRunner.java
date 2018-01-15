package org.usfirst.frc.team2363.util.pathplanning.commands;

import java.util.List;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.util.pathplanning.BoTHTrajectory;
import org.usfirst.frc.team2363.util.pathplanning.SrxPathReader;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motion.TrajectoryPoint;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PathRunner extends Command {
	
	private final String pathName;
	private boolean run;

	private volatile boolean leftIsFinished = false;
	private volatile boolean rightIsFinished = false;
	
    public PathRunner(String pathName) {
        requires(Robot.drivetrain);
        this.pathName = pathName;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	run = true;
    	Robot.drivetrain.setUpAutoControl();
    	BoTHTrajectory path = SrxPathReader.importSrxTrajectory(pathName);
    	new ProfileLoader(Robot.drivetrain.getLeft(), 
    			SrxPathReader.getTrajectoryPoints(path.getTrajectory().getLeftProfile()), false).start();
    	new ProfileLoader(Robot.drivetrain.getRight(), 
    			SrxPathReader.getTrajectoryPoints(path.getTrajectory().getRightProfile()), true).start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return isFinished;
    	  return leftIsFinished && rightIsFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	run = false;
    	Robot.drivetrain.setUpManualControl();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	run = false;
    }
    
    private class ProfileLoader extends Thread {
    	
    	private final TalonSRX talon;
    	private final List<TrajectoryPoint> points;
    	private boolean right_motor;
    	
    	private boolean started = false;
    	
    	public ProfileLoader(TalonSRX talon, List<TrajectoryPoint> points, boolean right_motor) {
    		this.talon = talon;
    		this.points = points;
    		this.right_motor = right_motor;
    	}

		@Override
		public void run() {
			//setup talon
			talon.changeMotionControlFramePeriod(5);
			talon.clearMotionProfileTrajectories();
			
			MotionProfileStatus status = new MotionProfileStatus();
			while (run && !points.isEmpty()) {
				//start the profile
				talon.getMotionProfileStatus(status);
				
				
				int bufferCount = status.topBufferCnt;
				if (!started && bufferCount > 5) {
					talon.set(ControlMode.MotionProfile, SetValueMotionProfile.Enable.value);
					started = true;
				}
				
				if (!talon.isMotionProfileTopLevelBufferFull()) {
					//set next point to send
					TrajectoryPoint point = points.remove(0);
					//send the point
					talon.pushMotionProfileTrajectory(point);
					talon.processMotionProfileBuffer();
					
					if (bufferCount <= 5)  {
						continue;
					}
				}
				talon.processMotionProfileBuffer();
				//sleep for 10ms
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					run = false;
				}
			}
			while (run && !status.isLast) {
				talon.getMotionProfileStatus(status);
				talon.processMotionProfileBuffer();
				//sleep for 10ms
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					run = false;
				}
			}
			
			//finish the motion profile
			talon.set(ControlMode.MotionProfile, SetValueMotionProfile.Disable.value);
			talon.clearMotionProfileTrajectories();
			talon.set(ControlMode.PercentOutput, 0);
			
			if (right_motor) {
				rightIsFinished = true;
			} else {
				leftIsFinished = true;
			}
		}
    }
}
