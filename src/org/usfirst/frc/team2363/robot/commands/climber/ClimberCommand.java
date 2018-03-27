package org.usfirst.frc.team2363.robot.commands.climber;

import org.usfirst.frc.team2363.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberCommand extends Command {

    public ClimberCommand() {
        requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.setPower(Robot.oi.getClimberPower());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
