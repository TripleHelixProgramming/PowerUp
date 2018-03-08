package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.AutoEject;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.commands.gripper.ShootCube;
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


    public SameSideScalePhase2(boolean flipped) {
    	addParallel(new RaiseElevator(Height.GROUND));
        addSequential(new FollowTrajectory(new SameSideScalePart2(flipped)));
        addParallel(new IntakeCube());
        addSequential(new FollowTrajectory(new SameSideScalePart3(flipped)));
        addParallel(new StopWheels());
        addSequential(new FollowTrajectory(new SameSideScalePart4(flipped)));
        addParallel(new RaiseElevator(Height.SCALE));
        addSequential(new FollowTrajectory(new SameSideScalePart5(flipped)));
        addParallel(new AutoEject());
        
    }
    
}
