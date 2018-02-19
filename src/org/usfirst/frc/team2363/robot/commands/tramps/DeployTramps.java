package org.usfirst.frc.team2363.robot.commands.tramps;

import org.iif.th.util.logger.HelixEvents;
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
    	HelixEvents.addEvent("TRAMPS", "Starting to deploy tramps");
    }

    protected void execute() {
    	Robot.tramps.deploy();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	HelixEvents.addEvent("TRAMPS", "Finished deploying tramps");
    }

    protected void interrupted() {
    }
}
