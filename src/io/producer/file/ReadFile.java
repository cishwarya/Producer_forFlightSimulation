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
	private static List<FlightLog> rows =  new ArrayList<FlightLog>();
	
	public static List<FlightLog> read() {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				List<String> items = Arrays.asList(sCurrentLine.split(","));
				//List<String> items = Arrays.asList(sCurrentLine.split(","));
				
/*				List<String> items = new ArrayList<String>();
				//items.addAll(Arrays.asList(sCurrentLine.split(",")));
				
				String[] parts = sCurrentLine.split(",");
				//System.out.println("File :: "+parts[5]);
				//items.forEach(item -> System.out.println("File : "+item));
				
				IntStream.range(0, parts.length)
						 .forEach(value -> {
							 items.add(parts[value]);
							 //System.out.println("File :: "+parts[value]);
							 });
				
				//System.out.println("size :: "+items.size());
				System.out.println("File :: "+items.get(2));*/
				
				
				FlightLog flightLog = new FlightLog(
						items.get(0),
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
}
