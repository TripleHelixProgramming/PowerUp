package org.usfirst.frc.team2363.util;

public class DrivetrainMath {
	
	public static double counts_per_wheelRev(int encoderCounts, double gearRatio) {
		//encoderCounts			counts/rev of encoder shaft						counts/rev
		//gearRatio				gear ratio between encoder shaft and wheel axle	unitless
		//counts_per_wheelRev	counts/rev of wheel shaft						counts/rev
		return (encoderCounts / gearRatio);
	}
	
	public static double travel_per_wheelRev(double wheelDiameter) {
		//wheelDiameter	wheel 	diameter	in
		//travel_per_wheelRev	length		in/rev
		return (wheelDiameter * Math.PI);
	}
	
	public static int count_per_travel(int encoderCounts, double gearRatio, double wheelDiameter) {
		//encoderCounts			counts/rev of encoder shaft						counts/rev
		//gearRatio				gear ratio between encoder shaft and wheel axle	unitless
		//wheelDiameter	wheel 	diameter										in
		//count_per_travel		counts per distance traveled					counts/in
		return (int) (counts_per_wheelRev(encoderCounts, gearRatio) / travel_per_wheelRev(wheelDiameter));
	}
	
	public static int rpm_per_ips(double ips, double wheelDiameter) {
		//ips			linear velocity					in/s
		//wheelDiameter	wheel diameter					in
		//rpm			angular velocity of wheel shaft rev/m
		return (int) (ips * 60.0 / (wheelDiameter * Math.PI));
	}
	
	public static double ips_per_rpm(int rpm, double wheelDiameter) {
		//rpm			angular velocity of wheel shaft rev/m
		//wheelDiameter	wheel diameter					in
		//ips			linear velocity					in/s	
		return (rpm * wheelDiameter * Math.PI / 60.0);
	}
	
	/*
	public static int ticksPerWheelRotation(int encoderTicks, double gearRatio) {
		return (int)(encoderTicks * 3 * gearRatio);
	}
	
	public static double fGain(int encoderTicks, double gearRatio, int RPM) {
		return 1023.0 / (rpmToNup100ms(encoderTicks, gearRatio, RPM));
	}
	
	public static int fpsToRpm(double fps, double wheelDiameter) {
		return (int)(fps * 60.0 * 12.0 / (wheelDiameter * Math.PI));
	}
	
	public static double rpmToNup100ms(int encoderTicks, double gearRatio, int RPM) {
		return RPM * (1.0 / 600.0) * ticksPerWheelRotation(encoderTicks, gearRatio);
	}
	*/
	
}
