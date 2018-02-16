package org.usfirst.frc.team2363.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.*;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.*;

/**
 *
 */
public class RaiseElevator extends Command {

	private Height height;
	
    public RaiseElevator(Height height) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(elevator);
    	this.height = height;
    	setTimeout(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	HelixEvents.addEvent("Starting to go to " + height.toString());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.goTo(height);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut() || Math.abs(Robot.elevator.getPosition() - height.getHeight()) < 50;
    }

    // Called once after isFinished returns true
    protected void end() {
    	HelixEvents.addEvent("Finished going to " + height.toString());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
