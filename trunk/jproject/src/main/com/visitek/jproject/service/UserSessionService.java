package com.visitek.jproject.service;

import java.util.Date;

import com.visitek.jproject.app.Constants;
import com.visitek.jproject.model.business.Session;
import com.visitek.jproject.model.business.User;
import com.visitek.jproject.service.exception.InvalidLoginException;
import com.visitek.jproject.util.Logger;


public class UserSessionService {

	
    static Session session;
	

    public static User getCurrentUser(){
    	return session.getUser();	
    }
    
    public User getUser() {
        return session.getUser();
    }

    public void setUser(User user) {
        session.setUser(user) ;
    }
    
    
    
    public static User login(String username, String password,String Ipaddress)  throws InvalidLoginException {
        Logger.info("authenticating {0}", username);
        
        User user = (User)Constants.em.createNamedQuery("login")
        				.setParameter("username", username)
        				.setParameter("password", password).getSingleResult();
        
        if (user == null) throw new InvalidLoginException ();
        	
        	session.setUser(user);
        	session.setLogIn(new Date());
        	session.setIp(Ipaddress);        	
        	Constants.em.persist(session);        	
		return user;                 
    }
    
    public static User logout(User user) throws InvalidLoginException {
    	
    	Session s =  (Session )Constants.em.createNamedQuery("getSessionbyUserId")
    									.setParameter("user_id", user.getId())
    									.getSingleResult();
    	if (s== null) throw new InvalidLoginException ();
    	s.setLogOut(new Date());
    	Constants.em.persist(s);    	
    	return null;
    }
    
    
    
}
