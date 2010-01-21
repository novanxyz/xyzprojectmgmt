package com.visitek.xyzproject.model.business;

import com.visitek.xyzproject.model.AbstractPersistentClass;
import com.visitek.xyzproject.model.Duration;

public class Preference extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;
	
	
	String hostname = "project.novanxyz.com";
	String locale = "en";	
	String currency = "Rp";
	int[] workdays = {1,2,3,4,5};	
	String defaultView = "home";
	String defaultStyle = "blueSKY";
	
	String smtpServer;
	String smtpUser;
	String smtpPassword;
	int notificationInterval  = Duration.DAY;
	
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int[] getWorkdays() {
		return workdays;
	}
	public void setWorkdays(int[] workdays) {
		this.workdays = workdays;
	}
	public String getDefaultView() {
		return defaultView;
	}
	public void setDefaultView(String defaultView) {
		this.defaultView = defaultView;
	}
	public String getDefaultStyle() {
		return defaultStyle;
	}
	public void setDefaultStyle(String defaultStyle) {
		this.defaultStyle = defaultStyle;
	}
	public String getSmtpServer() {
		return smtpServer;
	}
	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}
	public String getSmtpUser() {
		return smtpUser;
	}
	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}
	public String getSmtpPassword() {
		return smtpPassword;
	}
	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}
	public int getNotificationInterval() {
		return notificationInterval;
	}
	public void setNotificationInterval(int notificationInterval) {
		this.notificationInterval = notificationInterval;
	}
	
	
	
	

}
