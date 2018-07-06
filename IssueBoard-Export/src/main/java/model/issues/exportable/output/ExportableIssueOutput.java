package model.issues.exportable.output;

import java.io.FileWriter;
import java.io.IOException;

import model.issues.exportable.ExportableIssue;
import view.output.FileOutputTarget;

public class ExportableIssueOutput implements FileOutputTarget<ExportableIssue> {

	String folder;

	StringBuilder stringBuilder = new StringBuilder();
	
	FileWriter test;	
	
	Boolean writeHeader;
	
	@Override
	public void update() throws IOException {
		
		if (isOpen())
		{
			test.flush();
		}
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void write(ExportableIssue output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFolder(String folder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFileName(String file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

}
