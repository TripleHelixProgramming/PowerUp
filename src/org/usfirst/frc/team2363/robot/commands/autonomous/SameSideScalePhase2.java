package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.EjectCube;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.commands.gripper.StopWheels;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.SameSideScalePart2;
import org.usfirst.frc.team319.paths.SameSideScalePart3;
import org.usfirst.frc.team319.paths.SameSideScalePart4;
import org.usfirst.frc.team319.paths.SameSideScalePart5;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class SameSideScalePhase2 extends CommandGroup {


    public SameSideScalePhase2() {
        addSequential(new FollowTrajectory(new SameSideScalePart2()));
        addParallel(new RaiseElevator(Height.GROUND));
        addParallel(new IntakeCube());
        addSequential(new FollowTrajectory(new SameSideScalePart3()));
        addParallel(new StopWheels());
        addSequential(new FollowTrajectory(new SameSideScalePart4()));
        addParallel(new RaiseElevator(Height.SCALE));
        addSequential(new FollowTrajectory(new SameSideScalePart5()));
        addParallel(new EjectCube());
    }
    
}
