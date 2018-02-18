package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.commands.gripper.ShootCube;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.SameSideSwitchPart2;
import org.usfirst.frc.team319.paths.SameSideSwitchPart3;
import org.usfirst.frc.team319.paths.SameSideSwitchPart4;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SameSideSwitchPhase2 extends CommandGroup {

    public SameSideSwitchPhase2() {
    	 addSequential(new FollowTrajectory(new SameSideSwitchPart2()));
    	 addParallel(new RaiseElevator(Height.GROUND));
    	 addSequential(new FollowTrajectory(new SameSideSwitchPart3()));
    	 addParallel(new IntakeCube());
    	 addSequential(new FollowTrajectory(new SameSideSwitchPart4()));
    	 addSequential(new RaiseElevator(Height.SWITCH));
    	 addSequential(new ShootCube());
    }
}
