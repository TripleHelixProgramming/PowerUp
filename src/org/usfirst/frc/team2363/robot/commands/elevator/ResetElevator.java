package org.usfirst.frc.team2363.robot.commands.elevator;

import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetElevator extends Command {

    public ResetElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setPower(-0.15);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.atBottom();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
