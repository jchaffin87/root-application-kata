package com.jchaffin.rootcodechallenge;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	Driver testDriver;

	@Before
	public void setUp() {
		testDriver = new Driver("Test");
	}

	// Tests for getTotalMilesDriven method
	@Test
	public void getTotalMilesDrivenReturnsDistanceOfOneTripInDriversTripsArrayAsInt() {
		Trip testTrip = new Trip("Test", null, null, 10.1);
		testDriver.addTrip(testTrip);
		assertEquals((int) Math.round(testTrip.getDistance()), testDriver.getTotalDistanceDriven());
	}

	@Test
	public void getTotalMilesDrivenReturnsSumOfAllTripDistancesInTripsArray() {
		Trip testTrip1 = new Trip("Test", null, null, 10.1);
		testDriver.addTrip(testTrip1);
		Trip testTrip2 = new Trip("Test", null, null, 10.5);
		testDriver.addTrip(testTrip2);
		Trip testTrip3 = new Trip("Test", null, null, 10.1);
		testDriver.addTrip(testTrip3);
		int tripDistance1 = (int) Math.round(testTrip1.getDistance());
		int tripDistance2 = (int) Math.round(testTrip2.getDistance());
		int tripDistance3 = (int) Math.round(testTrip3.getDistance());
		assertEquals(tripDistance1 + tripDistance2 + tripDistance3, testDriver.getTotalDistanceDriven());
	}

	// Tests for getAverageSpeed
	@Test
	public void getAverageSpeedReturnsSpeedOfTripInDriversTripsArrayAsInt() throws ParseException {
		Trip testTrip = new Trip("Test", "07:15", "08:15", 60.5);
		testDriver.addTrip(testTrip);
		assertEquals((int) testTrip.getSpeed(), testDriver.getAverageSpeed());
	}

	@Test
	public void getAverageSpeedReturnsAverageSpeedOfTripsInDriversTripsArray() throws ParseException {
		Trip testTrip = new Trip("Test", "07:15", "08:15", 60.5);
		testDriver.addTrip(testTrip);
		Trip testTrip2 = new Trip("Test", "07:15", "08:15", 30);
		testDriver.addTrip(testTrip2);
		assertEquals(((int) (testTrip.getSpeed() + testTrip2.getSpeed()) / 2.0), testDriver.getAverageSpeed(), 0);
	}

}
