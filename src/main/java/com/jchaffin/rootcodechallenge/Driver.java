package com.jchaffin.rootcodechallenge;

import java.text.ParseException;
import java.util.ArrayList;

public class Driver {

	private String name;
	private int totalDistanceDriven = 0;
	private int averageSpeed = 0;

	private ArrayList<Trip> trips = new ArrayList<Trip>();

	protected Driver(String name) {
		this.name = name;
	}

	protected String getName() {
		return name;
	}

	protected void addTrip(Trip trip) {
		trips.add(trip);
	}

	protected ArrayList<Trip> getTrips() {
		return trips;
	}

	protected int getTotalDistanceDriven() {
		for (Trip trip : trips) {
			int distance = (int) Math.round(trip.getDistance());
			totalDistanceDriven += distance;
		}
		return totalDistanceDriven;
	}

	protected int getAverageSpeed() throws ParseException {
		ArrayList<Double> speeds = new ArrayList<>();
		for (Trip trip : trips) {
			speeds.add(trip.getSpeed());
		}
		int speedSum = 0;
		for (Double speed : speeds) {
			speedSum += speed;
		}
		averageSpeed = speedSum / trips.size();
		return averageSpeed;
	}

}
