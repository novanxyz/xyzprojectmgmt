package com.visitek.xyzproject.bean;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.visitek.xyzproject.model.business.Preference;
import com.visitek.xyzproject.model.business.Session;
import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.service.ConfigurationService;
import com.visitek.xyzproject.service.UserService;
import com.visitek.xyzproject.service.UserSessionService;
import com.visitek.xyzproject.service.exception.InvalidLoginException;

@ManagedBean
public class UserSessionBean {

	String username;
	String password;
	boolean loggedIn = false;
	
	Set<Preference> userconfig;
		
	public UserSessionBean() {
		
	}
	
	
	public boolean login(String uname, String passwd) throws InvalidLoginException{
						
		String sessionId 	= ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getId();
		String remoteAddr	= ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
		Session sess = UserSessionService.login(username,password,remoteAddr,sessionId);
		User user = sess.getUser();		
		userconfig = ConfigurationService.getUserPreferences(user);
		loggedIn = true;
		return loggedIn;						 		
	}
	
	public boolean logout() throws InvalidLoginException{
		String sessionId 	= ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getId();
		User u = UserService.findByName(username,false);
		UserSessionService.logout(u,sessionId);
		loggedIn = false;
		return loggedIn;		
	}
		
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;	}
	public void setPassword(String password) {this.password = password;}

	public boolean isLoggedIn() {return loggedIn;}
	public void setLoggedIn(boolean loggedIn) {this.loggedIn = loggedIn;}
	
	

}
