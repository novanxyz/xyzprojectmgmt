package com.visitek.jproject.service;

import java.util.List;

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
    
    
    
    public static User login(String username, String password)  throws InvalidLoginException {
        Logger.info("authenticating {0}", username);
        
        List<User> luser = Constants.em.createNamedQuery("login")
        				.setParameter("username", username)
        				.setParameter("password", password).getResultList();
        
        if (luser.size()== 0) return null;
        	session.setUser((User) luser.get(0));
		return null;                 
    }
    
    
    
}
