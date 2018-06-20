package csvFormatter.service;

import java.io.IOException;

public abstract class CsvFile {
	static String inputDelimiter = ",";
	static String formatDelimiter = ",";
	static String outputDelimiter = ",";
 public abstract void close() throws IOException;
 
 public static void setInputDelimiter(String s)
 {
	 inputDelimiter = s;
 }
 
 public static void setOutputDelimiter(String s)
 {
	 outputDelimiter = s;
 }
 
}
