package com.visitek.xyzproject.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.model.entity.Project;
import com.visitek.xyzproject.model.entity.Task;
import com.visitek.xyzproject.service.exception.DuplicateUserNameException;

public class TemplateService {
	
	EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager mgr){
		em = mgr;
	}
	
	public Project getProjectTemplate(String str){
		
		
		return  null;
	}
	
	public static Task getTaskTemplate(String str){
		return null;
	}
	
	public static User newUserFromSample(String username,User u) throws DuplicateUserNameException{
		
		if (username.equals(u.getUsername())) throw new DuplicateUserNameException("User already exist with the name");
		User newu = new User(username);
		newu.setRoles(u.getRoles());		
		return newu;
	}
		
		
}
