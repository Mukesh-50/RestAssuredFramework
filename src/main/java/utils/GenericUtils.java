package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericUtils 
{
	
	public static String getDateAndTime()
	{
		
		Date date=new Date();

		SimpleDateFormat customDate=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		
		String formattedDate=customDate.format(date);
		
		return formattedDate;
	}

}
