package org.usfirst.frc.team2363.robot.commands.drivetrain;

import static org.usfirst.frc.team2363.robot.Robot.drivetrain;
import static org.usfirst.frc.team2363.robot.Robot.oi;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickDrive extends Command {

    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	HelixEvents.addEvent("DRIVETRAIN", "Starting to start joystick drive");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
	    	double throttle, turn;
	    	
//	    	throttle = oi.getThrottle() * ((0.7 * (1 - Robot.elevator.getHeightPercentage())) + 0.3);
	    	throttle = oi.getThrottle() * 0.65;//xbox controller throttle
//	    	throttle = oi.getThrottle() * 0.8;//flight sim controller
	    	turn = oi.getTurn() * ((0.3 * (1 - Robot.elevator.getHeightPercentage())) + 0.7); //original: 0.4, 0.6;
	    	
	    	drivetrain.arcadeDrive(throttle, turn, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	HelixEvents.addEvent("DRIVETRAIN", "Finished starting joystick drive");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
