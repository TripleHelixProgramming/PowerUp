package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.util.pathplanning.commands.PathRunner;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class AutoGroup extends CommandGroup {

    public AutoGroup(String path, String elevatorHeight) {
        addParallel(new ElevatorRaise(elevatorHeight));
        addParallel(new GripperDeploy());
        addSequential(new PathRunner(path));
        addSequential(new CubeDeliver());
    }
}
