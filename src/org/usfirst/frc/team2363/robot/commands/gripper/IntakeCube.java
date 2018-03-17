package org.usfirst.frc.team2363.robot.commands.gripper;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.*;

import org.iif.th.util.logger.HelixEvents;

/**
 *
 */
public class IntakeCube extends Command {
	private int stalledCount = 0;
	
	Command rumbleCommand = new RumbleController();
	
    public IntakeCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(gripper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	gripper.lower();
    	HelixEvents.addEvent("GRIPPER", "Starting to intake cube");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (gripper.isOverCurrent()) {
    		stalledCount++;
    	} else {
    		stalledCount = 0;
    	}
		gripper.intake();
		
		if (stalledCount > 20) {
			if (!rumbleCommand.isRunning()) {
				rumbleCommand.start();
			}
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
//        return stalledCount > 5;
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	HelixEvents.addEvent("GRIPPER", "Finished intaking cube");
//    	if (!rumbleCommand.isRunning()) {
//			rumbleCommand.start();
//		}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}