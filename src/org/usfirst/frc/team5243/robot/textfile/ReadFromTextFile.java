package org.usfirst.frc.team5243.robot.textfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromTextFile {
	
	String path;
	ArrayList<String> readLines;
	
	public ReadFromTextFile(String filePath) {
		path = filePath;
		readLines = new ArrayList<String>();
	}
	
	public void read() throws IOException {
		FileReader reader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(reader);
		for (int i = 0; i < getNumberOfLines(); i++) {
			readLines.add(bufferedReader.readLine());
		}
		bufferedReader.close();
	}
	
	public int getNumberOfLines() throws IOException {
		FileReader reader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(reader);
		int lines = 0;
		while (bufferedReader.readLine() != null) {
			lines++;
		}
		bufferedReader.close();
		return lines;
	}
	
	public double getValue(int index, int slashNumber) {
		int slashes = 0;
		String atLine = readLines.get(index);
		String stringValue = "";
		outerloop:
		for (int i = 0; i < atLine.length(); i++) {
			if (atLine.substring(i, i+1).equals("/")) {
				slashes++;
				if (slashes == slashNumber) {
					for (int j = i + 1; j < atLine.length(); j++) {
						if (atLine.substring(j, j+1).equals("/")) {
							break outerloop;
						} else {
							stringValue += atLine.substring(j, j+1);
						}
					}
				}
			}
		}
		if (stringValue.equals(""))
			return 0.0;
		double value = Double.parseDouble(stringValue);
		return value;
	}
	
	public ArrayList<String> getLines() {
		return readLines;
	}

}
