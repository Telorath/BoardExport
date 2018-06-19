package service;

import view.output.OutputTarget;

/**
 * The main output service is meant to be used in realtime, so it is not
 * buffered.
 * 
 * @author kyle.bennett
 *
 */

public class MainOutputService implements OutputTarget {
	private OutputTarget outputTarget;

	public OutputTarget getOutputTarget() {
		return outputTarget;
	}

	public void setOutputTarget(OutputTarget outputTarget) {
		this.outputTarget = outputTarget;
	}

	@Override
	public void clear() {
		outputTarget.clear();
	}

	@Override
	public void printLine(String newln) {
		outputTarget.printLine(newln);
	}

}