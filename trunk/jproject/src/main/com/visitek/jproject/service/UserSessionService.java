package com.visitek.jproject.service;

import java.util.Date;

import com.visitek.jproject.app.Constants;
import com.visitek.jproject.model.business.Session;
import com.visitek.jproject.model.business.User;
import com.visitek.jproject.service.exception.InvalidLoginException;
import com.visitek.jproject.util.Logger;


public class UserSessionService {

	
    static Session session;

    public static User getCurrentUser(String sessId){
    	
    	try {
    		
    	if (sessId == "") return session.getUser();
    	Session session = (Session)Constants.em.createNamedQuery("sessionById")
    								.setParameter("session_id", sessId)
    								.setParameter("session_name",sessId)
    								.getSingleResult();
    		return session.getUser();
    		
    	} catch (Exception e) {
			return null;
		}
    	
    		
    }
    
       
    public static Session login(String username, String password,String Ipaddress,String sessId)  throws InvalidLoginException {
        Logger.info("authenticating {0}", username);
        
        User user = (User)Constants.em.createNamedQuery("login")
        				.setParameter("username", username)
        				.setParameter("password", password).getSingleResult();
        
        if (user == null) throw new InvalidLoginException ();
        
        Session session = new Session();
        
        	
        	session.setUser(user);
        	session.setLogIn(new Date());
        	session.setIp(Ipaddress);
        	session.setName(sessId);
        	Constants.em.persist(session);        
        	
		return session;                 
    }
    
    public static boolean logout(User user,String sess_id) throws InvalidLoginException {
    	
    	Session s =  (Session )Constants.em.createNamedQuery("getSessionbyUserId")
    									.setParameter("user_id", user.getId())
    									.getSingleResult();
    	if (s== null) throw new InvalidLoginException ();
    	s.setLogOut(new Date());
    	Constants.em.persist(s);    	
    	return true;
    }
    
    public static boolean logout(Session sess) throws InvalidLoginException {
    	
    	Session s =  (Session )Constants.em.createNamedQuery("getSessionbyId")
    									.setParameter("session_id", sess.getId())
    									.getSingleResult();
    	if (s== null) throw new InvalidLoginException ();
    	s.setLogOut(new Date());
    	Constants.em.persist(s);    	
    	return true;
    }
    
    
    
    
}
