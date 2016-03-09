package test;

import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Test {
	public static void main(String[] args) {
		//test-1
		//test-3
    	DateTime current = new DateTime(DateTimeZone.UTC);
    	String dob = "2016-03-8T22:19:47.000Z";
    	DateTimeFormatter f = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	DateTime date  = f.parseDateTime(dob);
    	DateTimeZone zone = date.getZone();
    	System.out.println("Hours Diff ----> " + Hours.hoursBetween(current, date).getHours());
    	System.out.println("Days Diff ----> " + Days.daysBetween(current, date).getDays());
    }
	
	public static DateTime asDateTimeForXmlGregorianCalendar(XMLGregorianCalendar xmlDate, String format) {
        return asDateTime(xmlDate.toString(),format);
    }
	
	public static DateTime asDateTime(String dateString, String format) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
        return asDateTime(dateString, fmt);
    }
	
	public static DateTime asDateTime(String dateString, DateTimeFormatter fmt) {
        DateTime temp = fmt.withOffsetParsed().parseDateTime(dateString);
        DateTimeZone zone = temp.getZone();
        DateTime dateTime = DateTime.parse(dateString, fmt);
        return dateTime.withZone(zone);
    }
}
