package org.usfirst.frc.team2363.robot.commands.gripper;

import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class WaitForIntakeToLower extends WaitCommand {
	
	boolean isGripperDown = false;

    public WaitForIntakeToLower() {
        // Use requires() here to declare subsystem dependencies
    	super(1);
        requires(Robot.gripper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.gripper.isDown()) {
    		isGripperDown = true;
    	} else {
    		Robot.gripper.lower();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return super.isFinished() || isGripperDown;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}