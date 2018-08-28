package com.jchaffin.rootcodechallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

	private ArrayList<Driver> drivers = new ArrayList<Driver>();

	protected void parseFile(File file) {
		registerDrivers(file);
		assignTrips(file);
	}

	protected void registerDrivers(File file) {
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
				if (command.equals("Driver") && words.hasNext()) {
					String name = words.next();
					Driver newDriver = new Driver(name);
					drivers.add(newDriver);
				}
			}
			words.close();
		}
		lines.close();
	}

	protected void assignTrips(File file) {
		ArrayList<Trip> createdTrips = createTrips(file);
		for (Trip trip : createdTrips) {
			for (Driver driver : drivers) {
				if (trip.getDriverName().equals(driver.getName())) {
					driver.addTrip(trip);
				}
			}
		}
	}

	protected ArrayList<Trip> createTrips(File file) {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		;
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
				if (command.equals("Trip") && words.hasNext()) {
					String name = words.next();
					String startTime = words.next();
					String stopTime = words.next();
					double milesDriven = words.nextDouble();
					Trip newTrip = new Trip(name, startTime, stopTime, milesDriven);
					trips.add(newTrip);
				}
			}
			words.close();
		}
		return trips;
	}

	protected ArrayList<Driver> getDriverData() {
		return drivers;
	}

}
