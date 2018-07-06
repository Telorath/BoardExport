package exceptions;

public class DateParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9202203263021280216L;

	public DateParseException(String dateString)
	{
		super(String.format("The date \"%s\" could not be formatted. Please format as \"%s\"", dateString, "MM-DD-YYYY"));
	}
	
}
