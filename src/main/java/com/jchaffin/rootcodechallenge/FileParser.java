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

	public void assignTrips(File file) {
		ArrayList<Trip> createdTrips = createTrips(file);
		for (Trip trip : createdTrips) {
			for (Driver driver : drivers) {
				if (trip.getDriverName().equals(driver.getName())) {
					driver.addTrip(trip);
				}
			}
		}
	}

	ArrayList<Trip> createTrips(File file) {
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

	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

}
