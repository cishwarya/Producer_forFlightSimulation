package io.producer.init;

import java.util.ArrayList;
import java.util.List;

import io.producer.file.ReadFile;

public class Main {
	
	private static List<List<String>> rows = new ArrayList<List<String>>();
       
	public static void main(String[] args) {
		rows = ReadFile.read();
		
		rows.forEach(row -> {
			System.out.println(row.get(0));
			
			//Thread.sleep(2second);
			//Change row to java object
			//change java object to json object
			//send post request to flightlog server
		});		
	}

}
