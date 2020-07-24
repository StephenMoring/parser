package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Enrollee;

public class Parser {
	
	private static List<Enrollee> initialEnrollees;
	private static final String FILENAME = "src/main/resources/test3.csv";
	private static final String CSV_SEPARATOR = ",";
	public static void main(String[] args) {
		readInitialCsv();
		List<List<Enrollee>> filesToWrite = EnrolleeProcessor.process(initialEnrollees);
		int counter = 0;
		for(List<Enrollee> list : filesToWrite) {
			writeToCSV(list, ++counter);
		}
		
	}
	
	private static void readInitialCsv(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		    String line = null;
		    initialEnrollees = new ArrayList<>();
		    //read line of column headers
		    br.readLine();
		    while((line = br.readLine()) != null){
		    	String[] record = line.split(",");
		    	Enrollee enrollee = new Enrollee(record);
		        initialEnrollees.add(enrollee);
		    }
		    br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

    private static void writeToCSV(List<Enrollee> enroleeList, int count)
    {
    		String folder = "src\\main\\resources\\";
		
		try{
			File file = new File(enroleeList.get(0).getInsurance() + ".csv");
			FileWriter fr = new FileWriter(file, true);
			for(int i = 0; i < enroleeList.size(); i++) {
				
				if(file.length() == 0) {
					fr.write("UserID,Name,Version,Insurance\r\n");
				}
				fr.write(enroleeList.get(i).getUserId() + "," + enroleeList.get(i).getName() + "," + enroleeList.get(i).getVersion() + "," + enroleeList.get(i).getInsurance() + "\r\n");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
}
