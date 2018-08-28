package com.jchaffin.rootcodechallenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trip {
	private String driverName;
	private String startTime;
	private String stopTime;
	private double distance;
	private int speed;

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

	public int getSpeed() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		try {
			Date start = format.parse(startTime);
			Date stop = format.parse(stopTime);
			long time = start.getTime() - stop.getTime();
			speed = (int) Math.round(time / distance);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return speed;
	}
}
