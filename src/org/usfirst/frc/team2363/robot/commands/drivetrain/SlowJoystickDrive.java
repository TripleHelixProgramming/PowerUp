package org.usfirst.frc.team2363.robot.commands.drivetrain;

import static org.usfirst.frc.team2363.robot.Robot.drivetrain;
import static org.usfirst.frc.team2363.robot.Robot.elevator;
import static org.usfirst.frc.team2363.robot.Robot.oi;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SlowJoystickDrive extends Command {
	
    public SlowJoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	HelixEvents.addEvent("DRIVETRAIN", "Starting to start SLOW joystick drive");
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	drivetrain.arcadeDrive(oi.getThrottle() * 0.3, oi.getTurn() * 0.7, false);
    	drivetrain.adjustForHeight(elevator.getHeightPercentage());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	HelixEvents.addEvent("DRIVETRAIN", "Finished starting SLOW joystick drive");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
