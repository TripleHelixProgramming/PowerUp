package org.iif.th.util.logger;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;

public class HelixEvents {
	
	private static final Notifier log = new Notifier(new LogSaver());
	private static Path file;
	private static String loggingLocation = "/home/lvuser/logs/";
	
	private static final Queue<String> events = new LinkedList<>();
	
	public static void startLogging() {
		File usb1 = new File("/media/sda1/");
		if (usb1.exists()) {
			loggingLocation = "/media/sda1/logs/";
		}
		createFile();
		log.startPeriodic(1);
	}
	
	public static void addEvent(String event) {
		events.add(
				new StringBuilder()
				.append(Instant.now().toString()).append("\t")
				.append(DriverStation.getInstance().getMatchTime()).append("t")
				.append(event).append("\n")
				.toString());
	}
	
	private static void createLogDirectory() throws IOException {
		File logDirectory = new File(loggingLocation);
		if (!logDirectory.exists()) {
			Files.createDirectory(Paths.get(loggingLocation));
		}
	}
	
	private static void createFile() {
		Writer output = null;
		try {
			createLogDirectory();
			if (DriverStation.getInstance().isFMSAttached()) {
				file = Paths.get(loggingLocation + 
						DriverStation.getInstance().getEventName() + "_"+ 
						DriverStation.getInstance().getMatchType() + 
						DriverStation.getInstance().getMatchNumber() + "Events.csv");
			} else {
				file = Paths.get(loggingLocation + "testEvents.csv");
			}
			if (!Files.exists(file)) {
				Files.createFile(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) { }
			}
		}
	}
	
	private static class LogSaver implements Runnable {
		
		@Override
		public void run() {
			while (!events.isEmpty()) {
				try {
					Files.write(file, events.remove().getBytes(), StandardOpenOption.APPEND);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}