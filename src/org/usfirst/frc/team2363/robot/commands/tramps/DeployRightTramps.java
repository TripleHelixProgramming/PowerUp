package org.usfirst.frc.team2363.robot.commands.tramps;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployRightTramps extends Command {

    public DeployRightTramps() {
        requires(Robot.tramps);
    }

    protected void initialize() {
    	HelixEvents.addEvent("TRAMPS", "Starting to deploy right tramps");
    }

    protected void execute() {
    	Robot.tramps.deployRight();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	HelixEvents.addEvent("TRAMPS", "Finished deploying right tramps");
    }

    protected void interrupted() {
    }
}
