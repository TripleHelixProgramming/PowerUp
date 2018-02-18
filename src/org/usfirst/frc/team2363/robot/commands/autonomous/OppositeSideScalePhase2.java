package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.commands.gripper.StopWheels;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.OppositeSideScalePart2;
import org.usfirst.frc.team319.paths.OppositeSideScalePart3;
import org.usfirst.frc.team319.paths.OppositeSideScalePart4;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class OppositeSideScalePhase2 extends CommandGroup {


    public OppositeSideScalePhase2() {
    	addParallel(new RaiseElevator(Height.GROUND));
        addSequential(new FollowTrajectory(new OppositeSideScalePart2()));
        addParallel(new IntakeCube());
//        addParallel(new OpenClaw());
        addSequential(new FollowTrajectory(new OppositeSideScalePart3()));
//        addParallel(new CloseClaw());
//        addSequential(new WaitCommand(0.25));
        addParallel(new StopWheels());
        addSequential(new FollowTrajectory(new OppositeSideScalePart4()));
//        addParallel(new RaiseElevator(Height.SCALE));
//        addSequential(new FollowTrajectory(new SameSideScalePart5()));
//        addParallel(new ShootCube());
        
    }
    
}
