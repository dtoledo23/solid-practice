package com.solid.practice.purchase.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	
	private final SimpleDateFormat simpleDateFormat;
	
	public DateFormatter(String format) {
		simpleDateFormat = new SimpleDateFormat(format);
	}
	
	public String format(Date date) {
		return simpleDateFormat.format(date);
	}

}
