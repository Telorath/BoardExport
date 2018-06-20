package csvFormatter.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import csvFormatter.model.Entry;
import csvFormatter.model.Format;
import csvFormatter.model.OneTokenException;
import csvFormatter.model.Property;

public class CsvReader extends CsvFile {
	BufferedReader fileReader;

	public CsvReader(String fileName) throws FileNotFoundException
	{
		fileReader = new BufferedReader(new FileReader(new File(fileName)));
	}
	
	private void addAllPropertyNames(Format format, List<String> propertyNameList)
	{
		for (int i = 0; i < propertyNameList.size(); i++)
		{
			Property property = new Property(propertyNameList.get(i));
			format.getPropertyList().add(property);
		}
	}
	
	private void addAllProperties(Format format, List<String> propertyNameList, List<String> propertyValueList)
	{
		for (int i = 0; i < propertyNameList.size(); i++)
		{
			Property property = new Property(propertyNameList.get(i), propertyValueList.get(i));
			format.getPropertyList().add(property);
		}
	}
	
	public Format readFormat() throws IOException
	{

		Format format = new Format();
		
		List<String> propertyNameList = new ArrayList<>();
		List<String> propertyValuesList = new ArrayList<>();
		
		String propertyNames = fileReader.readLine();
		
		String[] tokens = propertyNames.split(formatDelimiter);
		
		propertyNameList.addAll(Arrays.asList(tokens));
		
		try {
			String defaultValues = fileReader.readLine();
			if (defaultValues != null)
			{
				tokens = defaultValues.split(formatDelimiter);
				propertyValuesList.addAll(Arrays.asList(tokens));
				assert(propertyNameList.size() == propertyValuesList.size());				
			}
		}
		catch (IOException E)
		{

		}
		if (propertyValuesList.isEmpty())
		{
			addAllPropertyNames(format, propertyNameList);
		}
		else
		{
			addAllProperties(format, propertyNameList, propertyValuesList);
		}
		close();
		return format;
	}
	
	private Entry fromCsvString(Format format, String[] Tokens) throws OneTokenException
	{
		Entry entry = new Entry();
		
		if (Tokens.length < 2 && format.getPropertyList().size() != Tokens.length)
		{
			throw new OneTokenException();
		}
		
		assert(format.getPropertyList().size() == Tokens.length);
		
		for (int i = 0; i < format.getPropertyList().size(); i++)
		{
			entry.addProperty(format.getPropertyList().get(i).getName(), Tokens[i]);
		}

		return entry;
	}
	
	public List<Entry> readEntries(Format format) throws OneTokenException
	{
		List<Entry> entries = new ArrayList<Entry>();
		boolean notEoF = true;
		while (notEoF)
		{
			try {
				String line = fileReader.readLine();
				String[] tokens = line.split(inputDelimiter);
				entries.add(fromCsvString(format, tokens));
			}
			catch (PatternSyntaxException E)
			{
				throw new OneTokenException();
			}
			catch (OneTokenException E)
			{
				throw E;
			}
			catch (Exception E)
			{
				notEoF = false;
			}
		}
		return entries;
	}

	@Override
	public void close() throws IOException {
fileReader.close();		
	}	
}
