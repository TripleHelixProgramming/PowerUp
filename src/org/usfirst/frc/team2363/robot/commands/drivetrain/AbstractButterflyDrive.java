package org.usfirst.frc.team2363.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.*;

public abstract class AbstractButterflyDrive extends Command {
	
	public AbstractButterflyDrive() {
		// needs code from the drivetrain subsystem
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		// colson drive
		defaultDrive();
	}

	@Override
	protected void execute() {

		// reads speed and turn angle when driving
		drivetrain.arcadeDrive(-oi.getThrottle(), -oi.getTurn());
	}
	
	abstract protected void defaultDrive();

	@Override
	protected boolean isFinished() {
		// doesn't end
		return false;
	}

	@Override
	protected void end() { }

	@Override
	protected void interrupted() { }
}

