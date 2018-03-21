package org.usfirst.frc.team2363.robot.commands.elevator;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ManualPositionalElevator extends Command {
	
	double position;

    public ManualPositionalElevator() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	position = Robot.elevator.getPosition();
    	HelixEvents.addEvent("ELEVATOR", "Starting to move elevator");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error;
    	position += Robot.oi.getElevatorPower() * 200;
    	if (position > Elevator.MAX_HEIGHT) {
    		position = Elevator.MAX_HEIGHT;
    	} else if (position < 0) {
    		position = 0;
    	}
    	
    	Robot.elevator.goTo(position);
    	
    	error = position - Robot.elevator.getPosition();
    	SmartDashboard.putNumber("Manual Position", position);
    	SmartDashboard.putNumber("Error", error);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	HelixEvents.addEvent("ELEVATOR", "finished moving elevator");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	HelixEvents.addEvent("ELEVATOR", "finished moving elevator");
    }
}
