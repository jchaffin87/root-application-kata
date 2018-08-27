package com.jchaffin.rootcodechallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

	private ArrayList<Driver> drivers = new ArrayList<Driver>();

	public void registerDrivers(File file) {
		Scanner lines = null;
		try {
			lines = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.printf("ERROR: %s\n", ex);
		}
		while (lines.hasNextLine()) {
			Scanner words = new Scanner(lines.nextLine());
			while (words.hasNext()) {
				String command = words.next();
				if (command.equals("Driver")) {
					String name = words.next();
					Driver newDriver = new Driver(name);
					drivers.add(newDriver);
				}
			}
			words.close();
		}
		lines.close();
	}

	public void addDriver(Driver driver) {
		drivers.add(driver);
	}

	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

}
