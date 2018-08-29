package com.jchaffin.rootcodechallenge;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ReportGeneratorTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	ReportGenerator testGenerator;

	@Before
	public void setUp() {
		testGenerator = new ReportGenerator();
	}

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void generateReportPrintsCorrectOutputForFileWithOneDriverAndOneTrip() throws IOException, ParseException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Jack");
		writer.println("Trip Jack 07:15 08:15 30");
		writer.close();
		testGenerator.generateReport(testFile);
		assertEquals("Jack: 30 miles @ 30 mph", outContent.toString().trim());
	}

	@Test
	public void generateReportPrintsCorrectOutputForFileWithTwoDriversAndTrips() throws IOException, ParseException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Trip Bob 07:15 08:15 30");
		writer.println("Driver Bill");
		writer.println("Trip Bill 07:15 08:15 60");
		writer.close();
		testGenerator.generateReport(testFile);
		assertEquals("Bob: 30 miles @ 30 mph\r\n" + "Bill: 60 miles @ 60 mph", outContent.toString().trim());
	}

	@Test
	public void generateReportPrintsCorrectOutputForFileWithThreeDriversAndTwoTrips()
			throws IOException, ParseException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Trip Bob 07:15 08:15 30");
		writer.println("Driver Bill");
		writer.println("Trip Bill 07:15 08:15 60");
		writer.println("Driver Steve");
		writer.close();
		testGenerator.generateReport(testFile);
		assertEquals("Bob: 30 miles @ 30 mph\r\n" + "Bill: 60 miles @ 60 mph\r\n" + "Steve: 0 miles",
				outContent.toString().trim());
	}

}
