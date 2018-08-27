package com.jchaffin.rootcodechallenge;

public class Trip {
	private String driverName;
	private String startTime;
	private String stopTime;
	private double distance;

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
}
