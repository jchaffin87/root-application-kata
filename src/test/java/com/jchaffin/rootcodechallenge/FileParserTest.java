package com.jchaffin.rootcodechallenge;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FileParserTest {
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	FileParser testParser;

	@Before
	public void setUp() {
		testParser = new FileParser();
	}

	// Tests for registerDrivers method
	@Test
	public void registerDriversCreatesAndSavesDriverObjectWhenLineStartsWithDriver() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.close();
		testParser.registerDrivers(testFile);
		assertEquals(1, testParser.getDrivers().size());
	}

	@Test
	public void registerDriversCreatesAndSavesMultipleDriverObjectsWhenLinesStartWithDriver() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Driver Bill");
		writer.close();
		testParser.registerDrivers(testFile);
		assertEquals(2, testParser.getDrivers().size());
	}

	@Test
	public void registerDriversDoesNotCreateAndSaveDriverWithoutName() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Driver");
		writer.close();
		testParser.registerDrivers(testFile);
		assertEquals(1, testParser.getDrivers().size());
	}

	@Test
	public void registerDriversContinuesPastDriverWithoutName() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Driver");
		writer.println("Driver Bill");
		writer.println("Driver Bilbo");
		writer.close();
		testParser.registerDrivers(testFile);
		assertEquals(3, testParser.getDrivers().size());
	}

	// Tests for assignTrips method
	@Test
	public void createTripsCreatesTripWhenLineStartsWithTrip() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.close();
		testParser.createTrips(testFile);
		assertEquals(1, testParser.createTrips(testFile).size());
	}

	@Test
	public void createTripsCreatesMultipleTripsWhenLinesStartWithTrip() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.close();
		testParser.createTrips(testFile);
		assertEquals(2, testParser.createTrips(testFile).size());
	}

	@Test
	public void createTripsSkipsLinesWithoutTripInformation() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.println("Trip");
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.close();
		testParser.createTrips(testFile);
		assertEquals(2, testParser.createTrips(testFile).size());
	}

	// Tests for assignTrips method
	@Test
	public void assignTripsAddsTripToDriversTripsArray() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.close();
		testParser.registerDrivers(testFile);
		testParser.assignTrips(testFile);
		assertEquals(1, testParser.getDrivers().get(0).getTrips().size());
	}

	@Test
	public void assignTripsAddsMultipleTripsToDriversTripsArray() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.close();
		testParser.registerDrivers(testFile);
		testParser.assignTrips(testFile);
		assertEquals(2, testParser.getDrivers().get(0).getTrips().size());
	}

	@Test
	public void assignTripsAddsMultipleTripsToMultipleDriversTripsArray() throws IOException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Driver Bill");
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.println("Trip Bob 07:15 07:45 17.3");
		writer.println("Trip Bill 07:15 07:45 17.3");
		writer.println("Trip Bill 07:15 07:45 17.3");
		writer.close();
		testParser.registerDrivers(testFile);
		testParser.assignTrips(testFile);
		assertEquals(2, testParser.getDrivers().get(0).getTrips().size());
		assertEquals(2, testParser.getDrivers().get(1).getTrips().size());
	}

}
