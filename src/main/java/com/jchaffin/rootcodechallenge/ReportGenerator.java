package com.jchaffin.rootcodechallenge;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

public class ReportGenerator {

	FileParser parser = new FileParser();

	public void generateReport(File file) throws ParseException {
		parser.parseFile(file);
		ArrayList<Driver> driverData = parser.getDriverData();
		for (Driver driver : driverData) {
			String output = driver.getName() + ": " + driver.getTotalDistanceDriven() + " miles @ "
					+ driver.getAverageSpeed() + " mph";
			System.out.println(output.trim());
		}
	}

}
