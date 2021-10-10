package com.tradesmanager.util;

import java.util.LinkedHashMap;
import java.util.TreeSet;
import com.tradesmanager.entities.TradeData;

public class TradesManagerConstants {
	
	public static volatile LinkedHashMap<String, TreeSet<Integer>> tradeIdMap = new LinkedHashMap<String, TreeSet<Integer>>();
	public static volatile LinkedHashMap<String, TradeData> tradeDataMap = new LinkedHashMap<String, TradeData>();
	public static volatile LinkedHashMap<String, String> tradeDataDateMap = new LinkedHashMap<String, String>();

}
