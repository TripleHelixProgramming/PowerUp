package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.AutoEject;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.commands.gripper.StopWheels;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.OppositeSideScalePart2;
import org.usfirst.frc.team319.paths.OppositeSideScalePart3;
import org.usfirst.frc.team319.paths.OppositeSideScalePart4;
import org.usfirst.frc.team319.paths.SameSideScalePart5;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class OppositeSideScalePhase2 extends CommandGroup {


    public OppositeSideScalePhase2(boolean flipped) {
    	addParallel(new RaiseElevator(Height.GROUND));
        addSequential(new FollowTrajectory(new OppositeSideScalePart2(flipped)));
        addParallel(new IntakeCube());
        addSequential(new FollowTrajectory(new OppositeSideScalePart3(flipped)));
        addParallel(new StopWheels());
        addSequential(new FollowTrajectory(new OppositeSideScalePart4(flipped)));
        addParallel(new RaiseElevator(Height.SCALE));
        addSequential(new FollowTrajectory(new SameSideScalePart5()));
        addParallel(new AutoEject());
        
    }
    
}
