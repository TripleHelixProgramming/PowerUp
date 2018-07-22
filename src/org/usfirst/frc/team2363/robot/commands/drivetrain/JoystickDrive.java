package org.usfirst.frc.team2363.robot.commands.drivetrain;

import static org.usfirst.frc.team2363.robot.Robot.drivetrain;
import static org.usfirst.frc.team2363.robot.Robot.oi;

import static org.usfirst.frc.team2363.robot.subsystems.Drivetrain.DT_HALF_TRACK_WIDTH;
import static org.usfirst.frc.team2363.robot.subsystems.Drivetrain.MAX_DRIVESIDE_VELOCITY;
import static org.usfirst.frc.team2363.robot.subsystems.Drivetrain.ticks_per_100ms;

import org.iif.th.util.logger.HelixEvents;
//import org.usfirst.frc.team2363.robot.Robot;

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

    	/* deleting prior code
	    	double throttle, turn;
	    	
//	    	throttle = oi.getThrottle() * ((0.7 * (1 - Robot.elevator.getHeightPercentage())) + 0.3);
	    	throttle = oi.getThrottle() * 0.65;//xbox controller throttle
//	    	throttle = oi.getThrottle() * 0.8;//flight sim controller
	    	turn = oi.getTurn(); //original: 0.4, 0.6;
	    	
//	    	drivetrain.arcadeDrive(throttle, turn, false);
    	 */
    	
    	//read in joystick values from OI
    	//range [-1, 1]
    	double throttleInput = oi.getThrottle();
    	double turnInput = oi.getTurn();
 
    	//find the maximum possible value of (throttle + turn)
    	//along the vector that the arcade joystick is pointing
    	double saturatedInput;
    	double greaterInput = Math.max(Math.abs(throttleInput), Math.abs(turnInput));
    		//range [0, 1]
    	double lesserInput = Math.abs(throttleInput) + Math.abs(turnInput) - greaterInput;
    		//range [0, 1]
    	if (greaterInput > 0.0) {
    		saturatedInput = (lesserInput / greaterInput) + 1.0;
       		//range [1, 2]
    	}
    	else {
    		saturatedInput = 1.0;
    	}
     	
    	//scale down the joystick input values
    	//such that (throttle + turn) always has a range [-1, 1]
    	throttleInput = throttleInput / saturatedInput;
    	turnInput = turnInput / saturatedInput;
     	
    	double radialVelocityAtMidpoint = throttleInput * MAX_DRIVESIDE_VELOCITY;
    		//range [-full linear speed, full linear speed]
    		//units of linear speed (in/s)
    	double angularVelocity =  turnInput * MAX_DRIVESIDE_VELOCITY / DT_HALF_TRACK_WIDTH; 
    		//range [-full rotational speed, full rotational speed]
    		//units of rotational speed (rad/s);
    	double radialVelocityAtDriveside = angularVelocity * DT_HALF_TRACK_WIDTH;
    		//range [-full linear speed, full linear speed]
			//units of linear speed (in/s); 
      	
    	double left = (radialVelocityAtMidpoint + radialVelocityAtDriveside) * ticks_per_100ms;
    	double right = (radialVelocityAtMidpoint - radialVelocityAtDriveside) * ticks_per_100ms;
    	
	    drivetrain.drive(left, right);
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
