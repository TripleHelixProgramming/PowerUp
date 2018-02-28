package org.usfirst.frc.team2363.robot.commands.tramps;

import org.iif.th.util.logger.HelixEvents;
import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RetractTramps extends Command {

    public RetractTramps() {
        requires(Robot.tramps);
    }

    protected void initialize() {
    	HelixEvents.addEvent("TRAMPS", "Starting to retract tramps");
    }

    protected void execute() {
    	Robot.tramps.retract();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	HelixEvents.addEvent("TRAMPS", "Finished retracting tramps");
    }

    protected void interrupted() {
    }
}
