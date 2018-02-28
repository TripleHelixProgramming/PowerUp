package org.usfirst.frc.team2363.robot.commands.tramps;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployLeftTramps extends Command {

    public DeployLeftTramps() {
        requires(Robot.tramps);
    }

    protected void initialize() {
    	HelixEvents.addEvent("TRAMPS", "Starting to deploy left tramps");
    }

    protected void execute() {
    	Robot.tramps.deployLeft();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	HelixEvents.addEvent("TRAMPS", "Finished deploying left tramps");
    }

    protected void interrupted() {
    }
}
