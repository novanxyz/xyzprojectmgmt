package com.visitek.xyzproject.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class CaptchaBean {
	
	
	static String sessionKey= "Sess" + String.valueOf((Math.random()*1000000)* (new Date()).getTime() );
	static String value;

	public static boolean check(){
		
	String captchaValue = (String)  ((HttpSession) FacesContext.getCurrentInstance().
		        	getExternalContext().getSession(true)).getAttribute(sessionKey);		        
	if (captchaValue.equalsIgnoreCase(value)) return true;	
		return false;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
