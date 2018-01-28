package org.usfirst.frc.team2363.robot.commands.gripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreCube extends CommandGroup {

    public ScoreCube() {
        addSequential(new WaitForIntakeToLower());
        addParallel(new EjectCube());
    }
}