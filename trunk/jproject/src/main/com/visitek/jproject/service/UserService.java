package com.visitek.jproject.service;


import java.util.List;

import javax.persistence.EntityManager;

import com.visitek.jproject.app.Constants;
import com.visitek.jproject.model.business.User;
import com.visitek.jproject.service.exception.DuplicateUserNameException;
import com.visitek.jproject.service.exception.InvalidEmailException;
import com.visitek.jproject.service.exception.InvalidPasswordException;
import com.visitek.jproject.service.exception.NoSuchUserException;

public class UserService {

	
	private EntityManager em;
	
	public List<User> getAllUser(){
		List<User> userlist = em.createNamedQuery("getAllUser").getResultList();
								
		return userlist;
	} 
	
	public static User getUserbyId(int id){
		return (User)Constants.em.createNamedQuery("UserbyId").setParameter("id", id).getResultList().get(0);
	}
	
	public User getUserbyName(String name){
		return (User)Constants.em.createNamedQuery("UserbyName").setParameter("name", name).getResultList().get(0);
	}
	
	
	public static User createUser(User user) throws DuplicateUserNameException,InvalidEmailException{
		Constants.em.persist(user);
		return user;
	}
	
	public List<User> retrieveUser(String criteria) throws NoSuchUserException{
		
		return null;		
	}
	
	public void updateUser(User user){
		Constants.em.persist(user);
	}
	
	public void deleteUser(User user) {
		Constants.em.remove(user);
		user = null;
	}
	
	public void changePassword(User user, String oldpasswd, String newpasswd) throws InvalidPasswordException{
		
		if (authenticateUser(user, oldpasswd)){
			user.setPassword(newpasswd);
			Constants.em.persist(user);
		}else{ 
			throw new InvalidPasswordException();
		}
				
	}
	
	public void activateUser(User user){
		
	}
	
	public boolean authenticateUser(User user, String passwd ){
		
		return false;
	}

	
}
