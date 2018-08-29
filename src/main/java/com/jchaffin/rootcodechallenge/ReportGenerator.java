package com.jchaffin.rootcodechallenge;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

public class ReportGenerator {

	FileParser parser = new FileParser();

	protected void generateReport(File file) throws ParseException {
		parser.parseFile(file);
		ArrayList<Driver> driverData = parser.getDriverData();
		for (Driver driver : driverData) {
			if (driver.getTrips().size() != 0) {
				System.out.println(driver.getName() + ": " + driver.getTotalDistanceDriven() + " miles @ "
						+ driver.getAverageSpeed() + " mph");
			} else {
				System.out.println(driver.getName() + ": " + driver.getTotalDistanceDriven() + " miles");
			}
		}
	}
}
