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
	private static List<FlightLog> rows = new ArrayList<FlightLog>();
	
	public static List<FlightLog> read() {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				java.util.List<String> items = Arrays.asList(sCurrentLine.split(","));
				
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
