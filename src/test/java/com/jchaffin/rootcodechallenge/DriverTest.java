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
	public void getTotalMilesDrivenReturnsDistanceOfOneTripInDriversTripsArray() {
		Trip testTrip = new Trip("Test", null, null, 10.1);
		testDriver.addTrip(testTrip);
		assertEquals((int) Math.round(testTrip.getDistance()), testDriver.getTotalDistanceDriven());
	}

}
