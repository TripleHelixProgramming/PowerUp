package org.usfirst.frc.team2363.robot.commands.autonomous;


import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.paths.Baseline;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BaselineAutoGroup extends CommandGroup {

    public BaselineAutoGroup(boolean flipped) {
    	addSequential(new RaiseElevator(Height.DROP));
    	addSequential(new FollowTrajectory(new Baseline(flipped)));
    }
}
