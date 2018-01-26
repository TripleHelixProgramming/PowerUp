package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.gripper.EjectCube;
import org.usfirst.frc.team2363.robot.commands.gripper.LowerWrist;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team2363.util.pathplanning.BoTHTrajectory;
import org.usfirst.frc.team2363.util.pathplanning.commands.PathRunner;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class AutoGroup extends CommandGroup {

    public AutoGroup(String path, Height elevatorHeight) {
        addParallel(new RaiseElevator(elevatorHeight));
        addParallel(new LowerWrist());
        addSequential(new PathRunner(path));
        addSequential(new EjectCube());
    }
    public AutoGroup(BoTHTrajectory path, Height elevatorHeight, boolean reverse) {
        addParallel(new RaiseElevator(elevatorHeight));
        addSequential(new PathRunner(path, reverse));
        addSequential(new EjectCube());
    }
}
