package com.jchaffin.rootcodechallenge;

import java.io.File;
import java.text.ParseException;

public class ReportGeneratorApp {

	public static void main(String[] args) throws ParseException {
		if (args.length > 0) {
			File inputFile = new File(args[0]);
			ReportGenerator reportGenerator = new ReportGenerator();
			reportGenerator.generateReport(inputFile);
		}

	}

}
