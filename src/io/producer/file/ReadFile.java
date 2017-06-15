package io.producer.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
	private static final String FILENAME = "TraficServerLog.txt";
	private static List<List<String>> rows = new ArrayList<List<String>>();
	
	public static List<List<String>> read() {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				java.util.List<String> items = Arrays.asList(sCurrentLine.split(","));
				System.out.println(items.toString());
				rows.add(items);
				System.out.println("Reading done!");
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
