/**
 * @author R. Ardhian (rardhian@gmail.com)
 * August 2007
 */

package id.co.visitek.jproject.model;

import java.io.Serializable;
import java.util.Date;

public class Duration implements Serializable {
	public static final long serialVersionUID = 1L;
	
	long years;
	long months;
	long days;
	long hours;
	long minutes;
	long seconds;
	
	public Duration() {
		
	}
	
	public Duration(Date start, Date end){	   
	    long seconds = end.getTime() - start.getTime();
	    this.setSeconds(seconds % 60);	    
	    this.setMinutes(seconds % 60 % 60);
	    this.setHours(seconds % 86400);
	    this.setDays(seconds % (86400*30));
	    this.setMonths(seconds % (86400 * 365));
	    this.setYears(seconds/(86400 * 365));
	}
	
	public Duration(long seconds){
		
		this.setDays(seconds/86400);
		this.setHours( (seconds- this.getDays()*86400)/3600 );
		this.setMinutes((seconds- this.getDays()*86400 - this.getHours()*3600 )/60);
		this.setSeconds((seconds- this.getDays()*86400 - this.getHours()*60 - this.getMinutes()*60));		
	}

	public long getHours() {
		return hours;
	}

	public void setHours(long hours) {
		this.hours = hours;
	}

	public long getMinutes() {
		return minutes;
	}

	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}

	public long getSeconds() {
		return seconds;
	}

	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}

	public long getDays() {
		return days;
	}

	public void setDays(long days) {
		this.days = days;
	}
	
	
	
	public long getYears() {
	    return years;
	}

	public void setYears(long years) {
	    this.years = years;
	}

	public long getMonths() {
	    return months;
	}

	public void setMonths(long months) {
	    this.months = months;
	}

	public String toString(){
		String str ="";
		if (days>0)		str += days + " hari ";
		if (hours>0)	str += hours + " jam ";
		if (minutes>0) 	str += minutes + " menit " ;
		if ((hours == 0 && minutes == 0 ) && seconds != 0 ) str += seconds + " detik" ;
		return str;
	}
}
