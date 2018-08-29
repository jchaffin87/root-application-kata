package com.jchaffin.rootcodechallenge;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Trip {
	private String driverName;
	private String startTime;
	private String stopTime;
	private double distance;

	protected Trip(String driverName, String startTime, String stopTime, double distance) {
		this.driverName = driverName;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.distance = distance;
	}

	protected String getDriverName() {
		return driverName;
	}

	protected String getStartTime() {
		return startTime;
	}

	protected String getStopTime() {
		return stopTime;
	}

	protected double getDistance() {
		return distance;
	}

	protected double getSpeed() throws ParseException {
		LocalTime start = LocalTime.parse(startTime);
		LocalTime stop = LocalTime.parse(stopTime);
		long timeMin = start.until(stop, ChronoUnit.MINUTES);
		double timeHr = (timeMin / (double) 60);
		double speed = distance / timeHr;
		return speed;
	}
}
