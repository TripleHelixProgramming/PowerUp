package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team319.paths.SameSideScale;
import org.usfirst.frc.team319.paths.SameSideScalePart2;
import org.usfirst.frc.team319.paths.SameSideScalePart3;
import org.usfirst.frc.team319.paths.SameSideScalePart4;
import org.usfirst.frc.team319.paths.SameSideScalePart5;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class PathTesting extends CommandGroup {
	
    public PathTesting() {
        try {
//        	addSequential(new FollowTrajectory(importer.importSrxTrajectory("OppositeSideScale"), false));
//        	addSequential(new FollowTrajectory(importer.importSrxTrajectory("OppositeSideScalePart2"), false));
			addSequential(new FollowTrajectory(new SameSideScale()));
			addSequential(new FollowTrajectory(new SameSideScalePart2()));
			addSequential(new FollowTrajectory(new SameSideScalePart3()));
			addSequential(new FollowTrajectory(new SameSideScalePart4()));
			addSequential(new FollowTrajectory(new SameSideScalePart5()));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
