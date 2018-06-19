package view.output;

public class BufferedOutput implements BufferedOutputTarget {

	private OutputTarget outputTarget;

	private StringBuilder stringBuilder = new StringBuilder();

	@Override
	public void update() {
		outputTarget.printLine(stringBuilder.substring(0, stringBuilder.length() - 1));
		stringBuilder.setLength(0);
	}

	@Override
	public void clear() {
		outputTarget.clear();
		stringBuilder.setLength(0);
	}

	@Override
	public void printLine(String newln) {
		stringBuilder.append(newln + "\n");
	}

}
