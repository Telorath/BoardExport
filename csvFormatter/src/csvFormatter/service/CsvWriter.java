package csvFormatter.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import csvFormatter.model.Entry;
import csvFormatter.model.Format;

public class CsvWriter extends CsvFile {
	BufferedWriter fileWriter;

	public CsvWriter(String fileName) throws IOException
	{
		File outputFile = new File(fileName);
		
		outputFile.createNewFile();
		
		fileWriter = new BufferedWriter(new FileWriter(new File(fileName)));
	}
	
	public void writeEntry(Format format, Entry entry) throws IOException
	{
		fileWriter.write(entry.entryAsCSVString(format, outputDelimiter));
		fileWriter.newLine();
	}
	
	public void writeEntries(Format outputFormat, List<Entry> entries) throws IOException
	{
		for (Entry entry : entries) {
			writeEntry(outputFormat, entry);
		}		
	}
	
	
	@Override
	public void close() throws IOException
	{
		fileWriter.close();
	}
	
}
