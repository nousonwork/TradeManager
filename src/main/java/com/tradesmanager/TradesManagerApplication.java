package com.tradesmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.tradesmanager.controller.TradesController;
import com.tradesmanager.util.TradesDataGenerator;
import com.tradesmanager.util.TradesManagerConstants;
import com.tradesmanager.util.Util;

/**
 * Hello world!
 *
 */
public class TradesManagerApplication {
	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Trade data generation thread " + threadName);

			new TradesDataGenerator().tradeDataGenerator();

		});
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Trade data addition thread " + threadName);
			try {
				File file = new File("E:\\Study-Data\\TradesDataFiles\\");
				String filesList[] = file.list();
				for (String str : filesList) {
					System.out.println("file name = " + str);
					JSONObject obj = (JSONObject) new JSONParser()
							.parse(new FileReader("E:\\Study-Data\\TradesDataFiles\\" + str));
					new TradesController().addNewTradesData(obj.toJSONString());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		});

		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Trade data maturity date verifying thread " + threadName);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(new Date());
			// Date date2 = sdf.parse(
			// cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" +
			// (cal2.get(Calendar.DATE)-1));
			if(TradesManagerConstants.tradeDataDateMap.containsValue(cal2.get(Calendar.YEAR) + "-"
					+ (cal2.get(Calendar.MONTH) + 1) + "-" + (cal2.get(Calendar.DATE) - 1))) {
				
				for (Map.Entry<String, String> entry : TradesManagerConstants.tradeDataDateMap.entrySet()) {
				    String key = entry.getKey();
				    String dateStr = entry.getValue();
				    if(new Util().isExpired(dateStr)){
				    	TradesManagerConstants.tradeDataDateMap.remove(key);
				    	TradesManagerConstants.tradeDataMap.get(key).setExpired("Y") ;
				        
				    }
				}
				
			}else {
				try {
					Thread.currentThread().sleep(1000*60*60*24);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

	}
}
