package csvFormatter.model;

public class Entry {
	MapSet<String,Property> propertyMap = new MapSet<>();
	
	public String entryAsCSVString(Iterable<Property> format, String delimiter)
	{
		StringBuilder csvStringBuilder = new StringBuilder();
		csvStringBuilder.ensureCapacity(255);
		for (Property key : format)
		{
			csvStringBuilder.append('\"');
			if (propertyMap.containsKey(key))
			{
				String propertyValue = propertyMap.get(key).getValue();
				if (!propertyValue.trim().equals(""))
				{
					csvStringBuilder.append(propertyValue);				
				}
				else
				{
					csvStringBuilder.append(key.getValue());
				}	
			}
			else
			{
				csvStringBuilder.append(key.getValue());
			}
			csvStringBuilder.append('\"');
			csvStringBuilder.append(delimiter);
		}
		csvStringBuilder.delete(csvStringBuilder.length() - 1, csvStringBuilder.length());
		return csvStringBuilder.toString();
	}
		
	public void addProperty(String propertyName, String propertyValue)
	{
		propertyMap.put(new Property(propertyName.toLowerCase(), propertyValue));
	}
}