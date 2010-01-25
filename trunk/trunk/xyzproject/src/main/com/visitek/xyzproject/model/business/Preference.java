package com.visitek.xyzproject.model.business;

import com.visitek.xyzproject.model.AbstractPersistentClass;
import com.visitek.xyzproject.model.Duration;

public class Preference extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String hostname = "project.novanxyz.com";
	String locale = "en";
	String currency = "Rp";
	int[] workdays = { 1, 2, 3, 4, 5 };
	String defaultView = "home";
	String defaultStyle = "blueSKY";

	String smtpServer;
	String smtpUser;
	String smtpPassword;
	int notificationInterval = Duration.DAY;

	public String getCurrency() {
		return currency;
	}

	public String getDefaultStyle() {
		return defaultStyle;
	}

	public String getDefaultView() {
		return defaultView;
	}

	public String getHostname() {
		return hostname;
	}

	public String getLocale() {
		return locale;
	}

	public int getNotificationInterval() {
		return notificationInterval;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public String getSmtpUser() {
		return smtpUser;
	}

	public int[] getWorkdays() {
		return workdays;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDefaultStyle(String defaultStyle) {
		this.defaultStyle = defaultStyle;
	}

	public void setDefaultView(String defaultView) {
		this.defaultView = defaultView;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setNotificationInterval(int notificationInterval) {
		this.notificationInterval = notificationInterval;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}

	public void setWorkdays(int[] workdays) {
		this.workdays = workdays;
	}

}
