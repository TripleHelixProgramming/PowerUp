package org.usfirst.frc.team2363.robot.commands.tramps;

import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployTramps extends Command {

    public DeployTramps() {
    	requires(Robot.tramps);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.tramps.deploy();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
