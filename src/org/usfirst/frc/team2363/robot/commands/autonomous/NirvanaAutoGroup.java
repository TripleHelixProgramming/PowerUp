package org.usfirst.frc.team2363.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2363.robot.commands.autonomous.AutoGroup;
import org.usfirst.frc.team2363.util.pathplanning.commands.PathRunner;

/**
 *
 */
public class NirvanaAutoGroup extends CommandGroup {

    public NirvanaAutoGroup() {
        addSequential(new AutoGroup(new scalePath, new scaleHeight));
        addSequential(new TurnToAngle(180));
        addParallel(new RaiseElevator(ground));
        addParallel(new IntakeCube());
        addSequential(new PathRunner(pathtocube));
        addSequential(new RaiseElevator(switchHeight));
        addSequential(new PathRunner(shortpath));
        addParallel(new DeliverCube());
    }
}
