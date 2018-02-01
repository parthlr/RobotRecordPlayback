package org.usfirst.frc.team5243.robot.textfile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToTextFile{
	
	String path;
	
	public WriteToTextFile(String filePath) {
		path = filePath;
	}
	
	public void write(String line) throws IOException {
		FileWriter fileWriter = new FileWriter(path, true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(line);
		printWriter.println();
		printWriter.close();
	}

}
