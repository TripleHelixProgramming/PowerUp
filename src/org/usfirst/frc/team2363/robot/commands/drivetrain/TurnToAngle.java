package org.usfirst.frc.team2363.robot.commands.drivetrain;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class TurnToAngle extends PIDCommand {

    public TurnToAngle(double angle) {
    	super(0.04, 0.003, 0.002);
        requires(Robot.drivetrain);
        
 //     getPIDController().setToleranceBuffer(10);
        getPIDController().setAbsoluteTolerance(1);
        getPIDController().setContinuous(true);
        getPIDController().setInputRange(-180, 180);
        getPIDController().setOutputRange(-.3, .3);
        
        setSetpoint(angle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	HelixEvents.addEvent("DRIVETRAIN", "Starting to turn to angle");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	HelixEvents.addEvent("DRIVETRAIN", "Finished turning to angle");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    @Override
	protected double returnPIDInput() {
		return Robot.drivetrain.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
			Robot.drivetrain.tankDrive(-output, output);
	}
}
