package com.visitek.xyzproject.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import sun.security.provider.MD5;

import com.visitek.xyzproject.app.Constants;
import com.visitek.xyzproject.model.business.Role;
import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.service.exception.DuplicateUserNameException;
import com.visitek.xyzproject.service.exception.InvalidEmailException;
import com.visitek.xyzproject.service.exception.InvalidPasswordException;
import com.visitek.xyzproject.service.exception.NoSuchUserException;

public class UserService {

	
	private EntityManager em;
	
	public List<User> getAllUser(){
		List<User> userlist = em.createNamedQuery("getAllUser").getResultList();								
		return userlist;
	} 
	
	public static User getUserbyId(int id){
		return (User)Constants.em.createNamedQuery("UserbyId").setParameter("id", id).getSingleResult();
	}
	
	public static User getUserbyName(String name){
		return (User)Constants.em.createNamedQuery("UserbyName").setParameter("name", name).getSingleResult();
	}
	
	
	public static User createUser(User user) throws DuplicateUserNameException{
		
		try {
			User u = getUserbyName(user.getUsername());
			if (user != (null)) throw new DuplicateUserNameException();
		} catch (Exception e) {
			throw new DuplicateUserNameException();
		}
		
		Constants.em.persist(user);
		
		return user;
	}
	
	public static User createUser(String username,String password,String email) throws DuplicateUserNameException, InvalidEmailException{
		User u;
		try {
			u = getUserbyName(username);
			if (u!=null) throw new DuplicateUserNameException();			
		} catch (NoResultException ex) {
			
			u = new User();
			u.setUsername(username);
			u.setEmail(email);
			u.setActive(false);			
			u.setPassword(password);
			try {
				NotificationService.sendNewUserNotification(u);
				createUser(u);
			}catch (InvalidEmailException e) {
				u = null;
				throw new InvalidEmailException();
			}
						
		}catch (Exception e)		{
			throw new DuplicateUserNameException();
		}
		
		return u;
	}
		
	public List<User> retrieveUser(String criteria) throws NoSuchUserException{
		
		try {
			List<User> ul = Constants.em.createNamedQuery("UserList")
										.setParameter("criteria", criteria)
										.getResultList();
			if (ul.isEmpty()) throw new NoSuchUserException();			
			return ul;
		}catch (Exception e) {
			throw new NoSuchUserException();
		}
		
				
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
		user.setActive(true);
		Constants.em.persist(user);
	}
	
	public boolean authenticateUser(User user, String passwd ){
		
		try {
						
			User u = (User) Constants.em.createNamedQuery("authenticate")
											.setParameter("user_id", user.getId())
											.setParameter("passwd", passwd)	
											.getSingleResult();
			 if (u.equals(user)) return true;
		} catch (NonUniqueResultException e) {			
			return true;
		} catch (Exception e){
			
		}
		return false;
		
	}
	
	public void setUserRole(User user, Role role){
		user.getRoles().add(role);
		Constants.em.persist(user);
	}
	
	public void removeUserRole(User user, Role role){
		user.getRoles().remove(role);
		Constants.em.persist(user);
	}

	
}
