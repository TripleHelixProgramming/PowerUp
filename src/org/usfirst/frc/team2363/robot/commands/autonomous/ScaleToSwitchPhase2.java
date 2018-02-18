package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.commands.gripper.ShootCube;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.SameSideScalePart2;
import org.usfirst.frc.team319.paths.SameSideScalePart3;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class ScaleToSwitchPhase2 extends CommandGroup {


    public ScaleToSwitchPhase2() {
    	addParallel(new RaiseElevator(Height.GROUND));
        addSequential(new FollowTrajectory(new SameSideScalePart2()));
        addParallel(new IntakeCube());
        addSequential(new FollowTrajectory(new SameSideScalePart3()));
        addSequential(new RaiseElevator(Height.SWITCH));
        addParallel(new ShootCube());
        
    }
    
}
