package io.producer.init;

import java.util.ArrayList;
import java.util.List;

import io.producer.dto.FlightLog;
import io.producer.file.ReadFile;
import io.producer.rest.Rest;

public class Main {
	
	private static List<FlightLog> rows = new ArrayList<FlightLog>();
	     
	public static void main(String[] args) {
		rows = ReadFile.read();
		Rest.post(rows);			
	}

}
