package id.co.visitek.jproject.service;

import java.util.List;

import id.co.visitek.jproject.model.object.User;
import id.co.visitek.jproject.util.HibernateUtil;
import id.co.visitek.jproject.util.Logger;

public class UserSessionService {

    User user;

    public static User getCurrentUser(){	
	User actor = new User();
	
	return actor;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    public boolean authenticate(String username, String password)    {
        Logger.info("authenticating {0}", username);
        
        List<User> luser = HibernateUtil.getCurrentSession().getNamedQuery("Login")
        					.setString("username", username)
        					.setString(password, password).list();
        
        if (luser.size()== 0) return false;
        this.user = (User) luser.get(0);         
        return false;
    }
    
    
    
}
