package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.AutoEject;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.SameSideScalePart2;
import org.usfirst.frc.team319.paths.SameSideScalePart3;
import org.usfirst.frc.team319.paths.ScoreInSwitch;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class ScaleToSwitchPhase2 extends CommandGroup {


    public ScaleToSwitchPhase2(boolean flipped) {
        addSequential(new FollowTrajectory(new SameSideScalePart2(flipped)));
        addParallel(new RaiseElevator(Height.GROUND));
        addParallel(new IntakeCube());
        addSequential(new FollowTrajectory(new SameSideScalePart3(flipped)));
        addSequential(new RaiseElevator(Height.SWITCH));
        addSequential(new FollowTrajectory(new ScoreInSwitch()));
        addParallel(new AutoEject());
        
    }
    
}
