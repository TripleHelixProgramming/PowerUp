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
	
	public static double highest_percentage;

    public SlowJoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	HelixEvents.addEvent("DRIVETRAIN", "Starting to start SLOW joystick drive");
    	
    	highest_percentage = Robot.elevator.getHeightPercentage();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double throttle, turn, percentage;
   	
    	percentage = Robot.elevator.getHeightPercentage();
    	if (percentage > highest_percentage) highest_percentage = percentage;
    	
    	throttle = oi.getThrottle() * ((0.7 * (1 - highest_percentage)) + 0.3);
    	turn = oi.getTurn() * ((0.4 * (1 - highest_percentage)) + 0.6);
    	
    	drivetrain.arcadeDrive(throttle, turn, false);
    	drivetrain.adjustForHeight(highest_percentage);
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
