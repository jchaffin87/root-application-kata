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
	public void registerDriversCreatesAndSavesMultipleDriverObjectsWhenLineStartsWithDriver() throws IOException {
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

}
