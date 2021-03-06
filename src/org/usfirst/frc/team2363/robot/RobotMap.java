
package org.usfirst.frc.team2363.robot;

import com.ctre.phoenix.ErrorCode;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final double HIGH_SPEED_SCALING = 0.3;//original 0.50
	public static final double LOW_SPEED_SCALING = 0.70;//original 0.75
		
	//Controllers
	public static final int DRIVER_PORT = 0;
	public static final int OPERATOR_PORT = 1;
		
	//XboxOne Joysticks
	public static final int LEFT_STICK_X = 0;
	public static final int LEFT_STICK_Y = 1;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_STICK_X = 4;
	public static final int RIGHT_STICK_Y = 5;
	
	//XboxOne Buttons
	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int LB = 5;
	public static final int RB = 6;
	public static final int LOGO_LEFT = 7;
	public static final int LOGO_RIGHT = 8;
	public static final int LEFT_STICK_BUTTON = 9;
	public static final int RIGHT_STICK_BUTTON = 10;

	//Drivetrain Talons
	public static final int FRONT_LEFT_TALON_ID = 10;
	public static final int MIDDLE_LEFT_TALON_ID = 12;
	public static final int REAR_LEFT_TALON_ID = 14;
	public static final int FRONT_RIGHT_TALON_ID = 11;
	public static final int MIDDLE_RIGHT_TALON_ID = 13;
	public static final int REAR_RIGHT_TALON_ID = 15;

	//PCMs Currently using PCM_0 but is ready for use in the event that we could need 2 PCMs
	public static final int PCM_0 = 0;
	public static final int PCM_1 = 1;
	
	//Analog Switch
	public static final int ANALOG_INPUT = 0;
	
	//Climber Motors
	public static final int FRONT_CLIMBER = 40;
	public static final int REAR_CLIMBER = 41;

	//Gripper Solenoids
	public static final int CLAW_OPEN = 6;
	public static final int CLAW_CLOSE = 1;
	
	//Digital IO -Gripper
	public static final int HAS_CUBE = 0;
  
  //Elevator Digital IO
	public static final int DEFAULT_POSITION = 1;
  
	// Gripper TalonSRX
	public static final int GRIPPER_LEFT_WHEEL = 20;
	public static final int GRIPPER_RIGHT_WHEEL = 21;

	//Elevator Motors
	public static final int LEFT_ELEVATOR_MOTOR = 30;
	public static final int RIGHT_ELEVATOR_MOTOR = 31;
	
	//LIMIT SWITCHES
	public static final int ELEVATOR_GROUND_LIMIT_CHANNEL = 2;
	public static final int ELEVATOR_UPPER_LIMIT_CHANNEL = 3;

}





