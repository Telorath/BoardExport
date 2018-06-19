package view.output;

import java.io.IOException;

public class ConsoleOutputTarget implements OutputTarget {

	@Override
	public void clear() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}

	@Override
	public void printLine(String newln) {
		System.out.println(newln);
	}

}
