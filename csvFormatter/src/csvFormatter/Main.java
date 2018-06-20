package csvFormatter;

import csvFormatter.service.ConversionProcessor;
import csvFormatter.service.CsvFile;

public class Main {
	static final String RELATIVE_PATH = "C:/Users/kyle.bennett/Documents/Test Workspace/csvFormatter/src/resources/";
	static final String INPUT_FORMAT = "inputformatAddress.csv";
	static final String OUTPUT_FORMAT = "outputformatAddress.csv";
	static final String INPUT_FILE = "address_spectrum_confidence_score.csv";
	static final String OUTPUT_FILE = "Test.csv";
	
	public static void main(String[] args) {

		CsvFile.setInputDelimiter(",");
		
		CsvFile.setOutputDelimiter(",");
		
		ConversionProcessor processor = new ConversionProcessor(RELATIVE_PATH, INPUT_FORMAT, OUTPUT_FORMAT, INPUT_FILE, OUTPUT_FILE);
		
		processor.processConversion();
		
	}

}
