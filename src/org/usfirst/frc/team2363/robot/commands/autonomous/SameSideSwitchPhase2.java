package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.AutoEject;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.SameSideSwitchPart3;
import org.usfirst.frc.team319.paths.SameSideSwitchPart4;
import org.usfirst.frc.team319.paths.ScoreInSwitch;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SameSideSwitchPhase2 extends CommandGroup {

    public SameSideSwitchPhase2(boolean flipped) {
    	 addSequential(new FollowTrajectory(new SameSideSwitchPart3(flipped)));
    	 addParallel(new RaiseElevator(Height.GROUND));
    	 addParallel(new IntakeCube());
    	 addSequential(new FollowTrajectory(new SameSideSwitchPart4(flipped)));
    	 addSequential(new RaiseElevator(Height.SWITCH));
    	 addSequential(new FollowTrajectory(new ScoreInSwitch()));
    	 addSequential(new AutoEject());
    }
}
