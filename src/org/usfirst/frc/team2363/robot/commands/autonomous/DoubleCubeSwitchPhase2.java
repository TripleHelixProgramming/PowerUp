package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.EjectCube;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.DoubleCubeSwitchPart2;
import org.usfirst.frc.team319.paths.DoubleCubeSwitchPart3;
import org.usfirst.frc.team319.paths.DoubleCubeSwitchPart4;
import org.usfirst.frc.team319.paths.SameSideScalePart2;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DoubleCubeSwitchPhase2 extends CommandGroup {

    public DoubleCubeSwitchPhase2() {
    	 addSequential(new FollowTrajectory(new DoubleCubeSwitchPart2()));
    	 addParallel(new RaiseElevator(Height.GROUND));
    	 addSequential(new FollowTrajectory(new DoubleCubeSwitchPart3()));
    	 addParallel(new IntakeCube());
    	 addSequential(new FollowTrajectory(new DoubleCubeSwitchPart4()));
    	 addSequential(new RaiseElevator(Height.SWITCH));
    	 addSequential(new EjectCube());
    }
}
