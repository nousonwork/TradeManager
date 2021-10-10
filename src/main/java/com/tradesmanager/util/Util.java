package com.tradesmanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

	public static void main(String[] args) throws ParseException {

		System.out.println("isExpired = " + new Util().isExpired("2019-03-19"));
	}

	public boolean isExpired(String dateStr) {
		boolean isexpired = false;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1;
		try {
			date1 = sdf.parse(dateStr);
			// System.out.println(new Date().toString());
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(new Date());
			Date date2 = sdf.parse(
					cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1) + "-" + cal2.get(Calendar.DATE));

			// System.out.println("date1 : " + sdf.format(date1));
			//System.out.println("date2 : " + sdf.format(date2));

			if (date1.after(date2)) {
				//System.out.println("Date1 is after Date2");

			}

			if (date1.before(date2)) {
				//System.out.println("Date1 is before Date2");
				isexpired = true;
			}

			if (date1.equals(date2)) {
				//System.out.println("Date1 is equal Date2");
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isexpired;
	}

}
