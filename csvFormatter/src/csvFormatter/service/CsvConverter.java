package csvFormatter.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csvFormatter.model.Entry;
import csvFormatter.model.Format;
import csvFormatter.model.OneTokenException;

public class CsvConverter {

	Format inputFormat = null;

	Format outputFormat = null;

	public void loadInputFormat(String formatFile) throws IOException {
		CsvReader inputFormatFile = null;
		inputFormatFile = new CsvReader(formatFile);
		try {
			inputFormat = inputFormatFile.readFormat();
		} finally {
			inputFormatFile.close();
		}
	}

	public void loadOutputFormat(String formatFile) throws IOException {
		CsvReader outputFormatFile = new CsvReader(formatFile);

		try {
			outputFormat = outputFormatFile.readFormat();
		} finally {
			outputFormatFile.close();
		}
	}

	public void convert(String inputFile, String outputFile) throws IOException, OneTokenException {
		List<Entry> entryList = new ArrayList<>();

		CsvReader entryFile = new CsvReader(inputFile);

		List<Entry> entries = null;
		try {
			entries = entryFile.readEntries(inputFormat);
		}
		finally {
			entryFile.close();
		}
		CsvWriter outFile = new CsvWriter(outputFile);
		try {
			outFile.writeEntries(outputFormat, entries);
		} finally {
			outFile.close();
		}
	}
}