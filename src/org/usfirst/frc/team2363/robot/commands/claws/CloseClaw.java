package org.usfirst.frc.team2363.robot.commands.claws;

import edu.wpi.first.wpilibj.command.Command;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;

/**
 *
 */
public class CloseClaw extends Command {

    public CloseClaw() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.claws);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	HelixEvents.addEvent("CLAW", "Starting to close claw");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.claws.closeClaw();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	HelixEvents.addEvent("CLAW", "Finished closing claw");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
