package com.tradesmanager.util;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.tradesmanager.entities.TradeData;

public class JsonParser {

	public static void main(String[] args) throws Exception {

		File file = new File("E:\\Study-Data\\TradesDataFiles\\");
		String filesList[] = file.list();
		for (String str : filesList) {
			System.out.println("file name = " + str);
			JSONObject obj = (JSONObject) new JSONParser()
					.parse(new FileReader("E:\\Study-Data\\TradesDataFiles\\" + str));

			TradeData td = new TradeData();
			td.setTrade_id((String) obj.get("trade_id"));
			td.setVersion((String) obj.get("version"));
			td.setCounter_party_id((String) obj.get("counter_party_id"));
			td.setBook_id((String) obj.get("book_id"));
			td.setMaturity_date((String) obj.get("maturity_date"));
			td.setCreated_date((String) obj.get("created_date"));
			td.setExpired((String) obj.get("expired"));

			System.out.println("trade_id:" + td.getTrade_id() + "," + "version:" + td.getVersion() + ","
					+ "counter_party_id:" + td.getCounter_party_id() + "," + "book_id:" + td.getBook_id() + ","
					+ "maturity_date:" + td.getMaturity_date() + "," + "created_date:" + td.getCreated_date() + ","
					+ "expired:" + td.getExpired());

		}

	}

	public TradeData parseSingleRequest(String jsonData) {

		JSONObject obj;
		TradeData td = new TradeData();
		try {
			obj = (JSONObject) new JSONParser().parse(jsonData);

			td.setTrade_id((String) obj.get("trade_id"));
			td.setVersion((String) obj.get("version"));
			td.setCounter_party_id((String) obj.get("counter_party_id"));
			td.setBook_id((String) obj.get("book_id"));
			td.setMaturity_date((String) obj.get("maturity_date"));
			td.setCreated_date((String) obj.get("created_date"));
			td.setExpired((String) obj.get("expired"));

			System.out.println(
					"trade_id:" + td.getTrade_id() + "," + 
					"version:" + td.getVersion() + ","+ 
					"counter_party_id:" + td.getCounter_party_id() + "," + 
					"book_id:" + td.getBook_id() + ","+ 
					"maturity_date:" + td.getMaturity_date() + "," + 
					"created_date:" + td.getCreated_date() + ","+ 
					"expired:" + td.getExpired());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return td;
	}

}
