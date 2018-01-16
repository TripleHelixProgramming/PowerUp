package org.usfirst.frc.team2363.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class AutoGroup extends CommandGroup {

    public AutoGroup(String path, String elevatorHeight) {
        AddParallel(new ElevatorRaise());
        AddSequential(new PathRunner(path));
        AddSequential(new CubeDeposit());
    }
}
