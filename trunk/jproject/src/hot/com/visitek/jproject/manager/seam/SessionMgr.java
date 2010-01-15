package com.visitek.jproject.manager.seam;

import javax.servlet.http.HttpServletRequest;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.web.ServletContexts;

import com.visitek.jproject.app.Configuration;
import com.visitek.jproject.manager.IManager;
import com.visitek.jproject.model.business.Session;
import com.visitek.jproject.model.business.User;
import com.visitek.jproject.service.UserSessionService;
import com.visitek.jproject.service.exception.InvalidLoginException;

@Name("SessionMgr")
@Scope(ScopeType.SESSION)
public class SessionMgr implements IManager{
	
	
	@In("login.username")
	String username;
	@In ("login.password")
	String  password;
	
	@In("remoteAddr")
	String remoteAddr;
	@In
	Session session;
	static Configuration config;
	
	static {
		config = Configuration.getInstance();
	}
	
	public boolean login()throws InvalidLoginException{
		
		HttpServletRequest req = ServletContexts.getInstance().getRequest();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String ipAddress ="";
		
			User user = UserSessionService.login(username,password,remoteAddr );
			if (user.equals(null)) return false;
			session.setUser(user);
			
			return true;					 		 
	}
	
	
	public boolean logout (){
		
		return true;
	}
	

}
