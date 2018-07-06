package view.output;

import java.io.IOException;

public class ConsoleOutputTarget implements OutputTarget<String> {

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
	public void write(String newln) {
		System.out.println(newln);
	}

}
