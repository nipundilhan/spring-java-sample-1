package test.pkg.date_convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConvert {
	
	  public static void main(String[] args) {


		  String timestampAsString = "2018-11-02T01:02:03.123456789";
		  String substring = timestampAsString.substring(0, 10);
		  
		  String pattern = "yyyy-MM-dd";
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		  try {
			  System.out.println(substring);
			Date date = simpleDateFormat.parse(substring);
			
			LocalDate today = LocalDate.now(); 
			LocalDate birthday = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			
			Period p = Period.between(birthday, today);
			System.out.println(p.getYears());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 
		  

		  
		  
		}

}
