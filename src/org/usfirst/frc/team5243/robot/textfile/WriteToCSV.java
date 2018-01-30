package org.usfirst.frc.team5243.robot.textfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToCSV {
	
	private static final String FILE_HEADER = "frontleft,frontright,backleft,backright";
	
	public static void write(ArrayList<Double> fl,ArrayList<Double> fr, ArrayList<Double> bl, ArrayList<Double> br , String filename) throws IOException {
		FileWriter writer = new FileWriter(new File(filename));
		writer.write(FILE_HEADER);
		for (int i = 0; i < fl.size(); i++) {
			writer.write(fl.get(i)+","+fr.get(i)+","+bl.get(i)+","+br.get(i)+",");
		}
	}

}
