package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import vttp.batch5.sdf.task01.models.BikeEntry;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) throws IOException {

		// System.out.printf("hello, world\n");
		
			String dirPath = "task01";
			String fileName = "day.csv";
			String dirPathFileName = dirPath + File.separator + fileName;


			File directory = new File(dirPath);
			if (directory.exists()) {
				System.out.println("Directory exists");
			} else {
				directory.mkdir();
			}

			File file = new File(dirPathFileName);
			if (file.exists()) {
				System.out.println("file exists");
			} else {
				file.createNewFile();
			}


			Reader reader = new FileReader(dirPathFileName);
			ExtractData extractingData = new ExtractData(reader);
			List<BikeEntry> bikeEntries = extractingData.readCSV();
			
			// System.out.println(extractingData.count(bikeEntries));
		
		


	

		





		



	}
}
