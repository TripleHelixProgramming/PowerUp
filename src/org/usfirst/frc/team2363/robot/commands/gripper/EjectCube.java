package org.usfirst.frc.team2363.robot.commands.gripper;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.*;

import org.iif.th.util.logger.HelixEvents;

/**
 *
 */
public class EjectCube extends Command {

	
    public EjectCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(gripper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	HelixEvents.addEvent("GRIPPER", "Starting to eject cube");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gripper.eject();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	HelixEvents.addEvent("GRIPPER", "Finished ejecting cube");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}