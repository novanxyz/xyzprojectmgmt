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
import com.visitek.jproject.service.UserSessionService;
import com.visitek.jproject.service.exception.InvalidLoginException;

@Name("sessionMgr")
@Scope(ScopeType.SESSION)
public class SessionMgr implements IManager{
	
	/*
	@In
	String username;
	@In 
	String  password;
	*/
	@In
	Session session;
	static Configuration config;
	
	static {
		config = Configuration.getInstance();
	}
	
	public void login(){
		
		HttpServletRequest req = ServletContexts.getInstance().getRequest();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			session.setUser(UserSessionService.login(username,password));
		} catch (InvalidLoginException e) {
			// TODO Auto-generated catch block
			
		}
				
		 
		 
	}
	

}
