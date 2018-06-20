package csvFormatter.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import csvFormatter.model.OneTokenException;

public class ConversionProcessor {
	private final String RELATIVE_PATH;
	private final String INPUT_FORMAT;
	private final String OUTPUT_FORMAT;
	private final String INPUT_FILE;
	private final String OUTPUT_FILE;
	private CsvConverter converter = new CsvConverter();

	public ConversionProcessor(String relativePath, String inputFormat, String outputFormat, String inputFile,
			String outputFile) {
		RELATIVE_PATH = relativePath;
		INPUT_FORMAT = inputFormat;
		OUTPUT_FORMAT = outputFormat;
		INPUT_FILE = inputFile;
		OUTPUT_FILE = outputFile;
	}

	public boolean processConversion() {

		boolean shouldContinue = true;
		printSpacing();
		shouldContinue = loadOutputFormat();
		printSpacing();
		if (!shouldContinue) {
			return false;
		}
		shouldContinue = loadInputFormat();
		printSpacing();
		if (!shouldContinue)
		{
			return false;
		}
		shouldContinue = convertFiles();
		printSpacing();
		return shouldContinue;
	}

	private boolean convertFiles() {
		printLn(String.format("Converting input file: %s", getInputFilePath()));
		printLn(String.format("Targetting output file: %s", getOutputFilePath()));
		try {
			converter.convert(getInputFilePath(), getOutputFilePath());
		}
		catch (OneTokenException e)
		{
			printLn("Failed to read input file: found one or fewer properties per entry but expected more. Perhaps the delimiter was incorrect?");
			return false;
		}
		catch (FileNotFoundException e) {
			printLn("Failed to load input file: file not found!");
			return false;
		} catch (IOException e) {
			printLn("Failed to convert file!");
			return false;
		}
		printLn("Successfully converted file!");
		return true;
	}

	private boolean loadOutputFormat() {
		printLn(String.format("Loading output format file: %s", getOutputFormatPath()));
		try {
			converter.loadOutputFormat(getOutputFormatPath());
		} catch (FileNotFoundException e) {
			printLn("Failed to load output format file: file not found!");
			return false;
		} catch (IOException e) {
			printLn("Failed to load output format file!");
			return false;
		}

		printLn("Successfully loaded output format file!");
		return true;
	}

	private boolean loadInputFormat() {
		printLn(String.format("Loading input format file: %s", getInputFormatPath()));
		try {
			converter.loadInputFormat(getInputFormatPath());
		} catch (FileNotFoundException e) {
			printLn("Failed to load input format file: file not found!");
			return false;
		} catch (IOException e) {
			printLn("Failed to load input format file!");
			return false;
		}
		printLn("Successfully loaded input format file!");
		return true;
	}

	public static void printLn(String output) {
		System.out.println(output);
	}

	public String getInputFormatPath() {
		return RELATIVE_PATH + INPUT_FORMAT;
	}

	public String getOutputFormatPath() {
		return RELATIVE_PATH + OUTPUT_FORMAT;
	}

	public String getInputFilePath() {
		return RELATIVE_PATH + INPUT_FILE;
	}

	public String getOutputFilePath() {
		return RELATIVE_PATH + OUTPUT_FILE;
	}

	public static void printSpacing() {
		printLn("--------------------------------------------------------");
	}
}
