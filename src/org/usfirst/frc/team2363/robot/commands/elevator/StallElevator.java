package org.usfirst.frc.team2363.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.*;

import org.iif.th.util.logger.HelixEvents;

/**
 *
 */
public class StallElevator extends Command {

    public StallElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	HelixEvents.addEvent("Stalling elevator");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevator.setPower(0.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
