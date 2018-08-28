package com.jchaffin.rootcodechallenge;

import java.util.ArrayList;

public class Driver {

	private String name;
	private int totalDistanceDriven;
	private int averageSpeed;

	private ArrayList<Trip> trips = new ArrayList<Trip>();

	public Driver(String name) {
		this.name = name;
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public int getTotalDistanceDriven() {
		for (Trip trip : trips) {
			int distance = (int) Math.round(trip.getDistance());
			totalDistanceDriven += distance;
		}
		return totalDistanceDriven;
	}

	public int getAverageSpeed() {
		ArrayList<Integer> speeds = new ArrayList<>();
		for (Trip trip : trips) {
			speeds.add(trip.getSpeed());
		}
		int speedSum = 0;
		for (Integer speed : speeds) {
			speedSum += speed;
		}
		averageSpeed = speedSum / trips.size();
		return averageSpeed;
	}

	public String getName() {
		return name;
	}
}
