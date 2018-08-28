package com.jchaffin.rootcodechallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	Driver testDriver;

	@Before
	public void setUp() {
		testDriver = new Driver("Test");
	}

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

}
