package com.tradesmanager.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONObject;

public class TradesDataGenerator {
	
	public static void main(String[] args) {
		
		
	}
	
	
	public void tradeDataGenerator() {
try {
			
			for(int i= 0; i<1000; i++ ) {
				FileOutputStream fos = new FileOutputStream("E:\\Study-Data\\TradesDataFiles\\"+new java.util.Random().nextInt(1000)+".json");
				int tradeId = new java.util.Random().nextInt(500);
				int versionId = new java.util.Random().nextInt(20);
				int cpId = new java.util.Random().nextInt(50);
				int bookId = new java.util.Random().nextInt(50);
				
				
				LocalDate startDate = LocalDate.of(2019, 2, 1); //start date
			    long start = startDate.toEpochDay();
			   // System.out.println(start);

			    LocalDate endDate =LocalDate.of(2019, 7, 19); //end date
			    long end = endDate.toEpochDay();
			   // System.out.println(start);

			    long maturityDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
			   // System.out.println(LocalDate.ofEpochDay(maturityDate)); // random date between the range
			    
			    long createdDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
			    //System.out.println(LocalDate.ofEpochDay(createdDate)); // random date between the range
			    
			   /* System.out.println("{"
			    		+ "tradeId:"+"T"+tradeId+
			    		+ "version:"
			    		+ "counter_party_id:"
			    		+ "book_id:"
			    		+ "maturity_date:"
			    		+ "created_date:"
			    		+ "expired:N"
			    		+ "}"); */
			    JSONObject jo = new JSONObject();
			    jo.put("trade_id", "T"+tradeId);
			    jo.put("version", ""+versionId);
			    jo.put("counter_party_id",""+ cpId);
			    jo.put("book_id", ""+bookId);
			    jo.put("maturity_date", ""+LocalDate.ofEpochDay(maturityDate)+"");
			    jo.put("created_date", ""+LocalDate.ofEpochDay(createdDate)+"");
			    jo.put("expired", "N");
			    
			    System.out.println(jo.toJSONString());
			    
			    fos.write(jo.toJSONString().getBytes());
			    fos.close();
			}
	    
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
