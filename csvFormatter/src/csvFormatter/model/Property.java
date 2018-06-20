package csvFormatter.model;

public class Property implements KeyedType<String> {
	private String name;
	private String value = "";

	public Property(String propertyName) {
		this.name = propertyName.toLowerCase();
	}

	public Property(String propertyName, String defaultValue) {
		this.name = propertyName.toLowerCase();
		this.value = defaultValue;
	}

	public String getName() {
		return name;
	}

	public String getValue()
	{
		return value;
	}
	
	@Override
	public String getKey() {
		return getName();
	}
	
	public String toString()
	{
		return name;
	}
	
}