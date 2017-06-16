package io.producer.rest;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import io.producer.dto.FlightLog;

public class Rest {
	
	private static final String url = "http://localhost:8080";
	
	public static void post(List<FlightLog> rows) {
		rows.forEach(row -> {
			System.out.println();
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		      RestTemplate restTemplate = new RestTemplate();		 
		      String response = restTemplate.postForObject(url+"/post/", row, String.class);
		      
		      if (response.equals("Saved")) {
		    	  System.out.println("serial number : "+ row.getsNo() +" "+response);
			}
		});		
	}

}
