package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.claws.CloseClaw;
import org.usfirst.frc.team2363.robot.commands.claws.OpenClaw;
import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.AutoEject;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.commands.gripper.StopWheels;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.CenterSwitchPart2;
import org.usfirst.frc.team319.paths.CenterSwitchPart3;
import org.usfirst.frc.team319.paths.CenterSwitchPart4;
import org.usfirst.frc.team319.paths.CenterSwitchPart5;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitchPhase2 extends CommandGroup {
	
	 public CenterSwitchPhase2(boolean flipped) {
	        addSequential(new FollowTrajectory(new CenterSwitchPart2(flipped)));
	        addParallel(new RaiseElevator(Height.GROUND));
	        addParallel(new OpenClaw());
	        addParallel(new IntakeCube());
	        addSequential(new FollowTrajectory(new CenterSwitchPart3(flipped)));
	        addParallel(new CloseClaw());
//	        addParallel(new StopWheels());
	        addSequential(new FollowTrajectory(new CenterSwitchPart4(flipped)));
//	        addParallel(new CloseClaw());
	        addParallel(new StopWheels());
	        addParallel(new RaiseElevator(Height.SWITCH));
	        addSequential(new FollowTrajectory(new CenterSwitchPart5(flipped)));
//	        addSequential(new AutoEject());
	    }

}
