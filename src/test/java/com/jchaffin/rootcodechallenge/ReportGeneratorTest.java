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
//	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
//	private final PrintStream originalErr = System.err;

	ReportGenerator testGenerator;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
//		System.setErr(new PrintStream(errContent));
	}

	@Before
	public void setUp() {
		testGenerator = new ReportGenerator();
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
//		System.setErr(originalErr);
	}

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void generateReportPrintsCorrectOutputForFileWithOneDriverAndOneTrip() throws IOException, ParseException {
		File testFile = folder.newFile("test.txt");
		PrintWriter writer = new PrintWriter(testFile);
		writer.println("Driver Bob");
		writer.println("Trip Bob 07:15 08:15 30");
		writer.close();
		testGenerator.generateReport(testFile);
		assertEquals("Bob: 30 miles @ 30 mph", outContent.toString().trim());
	}

}
