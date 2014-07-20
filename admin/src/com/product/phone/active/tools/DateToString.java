package com.product.phone.active.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {

	public static String dateToString(Date date) {
		SimpleDateFormat dateToStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = dateToStr.format(date);
		System.out.println(dateString);
		return dateString;
	}

}
