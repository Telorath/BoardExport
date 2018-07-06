package service;

import view.output.OutputTarget;

/**
 * The main output service is meant to be used in realtime, so it is not
 * buffered.
 * 
 * @author kyle.bennett
 *
 */

public class MainOutputService implements OutputTarget<String> {
	private OutputTarget<String> outputTarget;

	public OutputTarget<String> getOutputTarget() {
		return outputTarget;
	}

	public void setOutputTarget(OutputTarget<String> outputTarget) {
		this.outputTarget = outputTarget;
	}

	@Override
	public void clear() {
		outputTarget.clear();
	}

	@Override
	public void write(String newln) {
		outputTarget.write(newln);
	}

}