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

	public String getName() {
		return name;
	}

	public int getTotalDistanceDriven() {
		return totalDistanceDriven;
	}

	public int getAverageSpeed() {
		return averageSpeed;
	}

}
