package com.jchaffin.rootcodechallenge;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Trip {
	private String driverName;
	private String startTime;
	private String stopTime;
	private double distance;
//	private int speed;

	public Trip(String driverName, String startTime, String stopTime, double distance) {
		this.driverName = driverName;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.distance = distance;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public double getDistance() {
		return distance;
	}

	public double getSpeed() throws ParseException {
		LocalTime start = LocalTime.parse(startTime);
		LocalTime stop = LocalTime.parse(stopTime);
		long timeMin = start.until(stop, ChronoUnit.MINUTES);
		double timeHr = (timeMin / (double) 60);
		double speed = distance / timeHr;
		return speed;
	}
}
