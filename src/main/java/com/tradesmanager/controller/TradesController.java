package com.tradesmanager.controller;

import java.util.TreeSet;

import com.tradesmanager.entities.TradeData;
import com.tradesmanager.util.JsonParser;
import com.tradesmanager.util.TradesManagerConstants;
import com.tradesmanager.util.Util;

public class TradesController {
	
	

	public void addNewTradesData(String jsonData) {
		TradeData td = new JsonParser().parseSingleRequest(jsonData);

		
		if (TradesManagerConstants.tradeIdMap.containsKey(td.getTrade_id())) {
			Integer newVersionnumber = TradesManagerConstants.tradeIdMap.get(td.getTrade_id())
					.ceiling(Integer.parseInt(td.getVersion()));
			if ( newVersionnumber == null) {

				if (!new Util().isExpired(td.getMaturity_date())) {
					TradesManagerConstants.tradeIdMap.get(td.getTrade_id()).add(Integer.parseInt(td.getVersion()));
					TradesManagerConstants.tradeDataMap.put(td.getTrade_id() + td.getVersion(), td);
					TradesManagerConstants.tradeDataDateMap.put(td.getTrade_id() + td.getVersion(), td.getMaturity_date());
				} else {
					System.out.println("The maturity date is expired");
				}

			} else if(newVersionnumber == Integer.parseInt(td.getVersion())) {
				TradesManagerConstants.tradeDataMap.put(td.getTrade_id() + td.getVersion(), td);
			}else {
				System.out.println("Higher version trade already exists for this trade id");
			}

		}else {
			TreeSet<Integer> versionSet = new TreeSet<Integer>();
			versionSet.add(Integer.parseInt(td.getVersion()));
			TradesManagerConstants.tradeIdMap.put(td.getTrade_id(), versionSet);
			TradesManagerConstants.tradeDataMap.put(td.getTrade_id() + td.getVersion(), td);
			TradesManagerConstants.tradeDataDateMap.put(td.getTrade_id() + td.getVersion(), td.getMaturity_date());
			System.out.println("*** Trade added successfully ***");
		}

	}
}
