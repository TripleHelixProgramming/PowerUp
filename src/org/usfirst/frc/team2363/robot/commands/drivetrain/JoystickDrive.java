package org.usfirst.frc.team2363.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.*;

import org.iif.th.util.logger.HelixEvents;

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
    	drivetrain.arcadeDrive(oi.getThrottle(), oi.getTurn(), false);
    	drivetrain.adjustForHeight(elevator.getHeightPercentage(false));
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
