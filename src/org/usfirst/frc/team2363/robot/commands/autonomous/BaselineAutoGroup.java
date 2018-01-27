package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.util.pathplanning.commands.PathRunner;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BaselineAutoGroup extends CommandGroup {

    public BaselineAutoGroup(String path) {
        addSequential(new PathRunner(path));
    }
}
