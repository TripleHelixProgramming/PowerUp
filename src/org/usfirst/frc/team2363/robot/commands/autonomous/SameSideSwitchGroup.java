package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.AutoEject;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.SameSideSwitch;
import org.usfirst.frc.team319.paths.SameSideSwitchPart1point3;
import org.usfirst.frc.team319.paths.SameSideSwitchPart1point6;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SameSideSwitchGroup extends CommandGroup {

    public SameSideSwitchGroup(boolean flipped) {
    	addSequential(new RaiseElevator(Height.DROP));
    	addSequential(new FollowTrajectory(new SameSideSwitch(flipped)));
    	addSequential(new RaiseElevator(Height.SWITCH));
    	addSequential(new FollowTrajectory(new SameSideSwitchPart1point3(flipped)));
    	addSequential(new FollowTrajectory(new SameSideSwitchPart1point6(flipped)));
    	addSequential(new AutoEject());
    	
        
    }
}
