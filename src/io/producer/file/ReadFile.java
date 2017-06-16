package io.producer.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.producer.dto.FlightLog;

public class ReadFile {
	private static final String FILENAME = "TraficServerLog.txt";
	private static List<FlightLog> rows  =  new ArrayList<FlightLog>();
	
	

	
	public static List<FlightLog> read() {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				List<String> items = Arrays.asList(sCurrentLine.split("\t*\\s*,\\s*\t*"));
				
				String sNo = sNoPreProcess(items.get(0));
								
				FlightLog flightLog = new FlightLog(
						sNo,
						items.get(1),
						items.get(2),
						items.get(3),
						items.get(4),
						items.get(5),
						items.get(6),
						items.get(7),
						items.get(8),
						items.get(9),
						items.get(10),
						items.get(11));
				
				rows.add(flightLog);				
			}
		
		return rows;
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}




	private static String sNoPreProcess(String sno) {
		/*Because can not remove the indent space*/
		String numberAsString = sno;
		float number = Float.parseFloat(numberAsString);
		String sNo = String.valueOf(number);
		
		System.out.println("Before "+sNo);
		
		String[] parts = sNo.split("\\.");
		System.out.println("Parts length : "+parts.length);
		
		if (parts[1].length() != 2) {
			sNo += "0";
		}
		
		System.out.println("After "+sNo);
		
		return sNo;
	}
}
