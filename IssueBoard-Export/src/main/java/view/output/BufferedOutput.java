package view.output;

public class BufferedOutput implements BufferedOutputTarget<String> {

	private OutputTarget<String> outputTarget;

	private StringBuilder stringBuilder = new StringBuilder();

	@Override
	public void update() {
		outputTarget.write(stringBuilder.substring(0, stringBuilder.length() - 1));
		stringBuilder.setLength(0);
	}

	@Override
	public void clear() {
		outputTarget.clear();
		stringBuilder.setLength(0);
	}

	@Override
	public void write(String newln) {
		stringBuilder.append(newln + "\n");
	}

}
