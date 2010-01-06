package id.co.visitek.jproject.service;

import id.co.visitek.jproject.model.object.User;
import id.co.visitek.jproject.util.HibernateUtil;

import java.util.List;

public class UserService {

	
	public List<User> getAllUser(){
		List<User> userlist = HibernateUtil.getCurrentSession()
								.getNamedQuery("getAllUser").list();
		return userlist;
	} 
	
	public static User getUserbyId(int id){
		return (User)HibernateUtil.getCurrentSession().getNamedQuery("UserbyId").setInteger("id", id).list().get(0);
	}
	
	public User getUserbyName(String name){
		return (User)HibernateUtil.getCurrentSession().getNamedQuery("UserbyName").setString("name", name).list().get(0);
	}
	
	
	public void createUser(){
		
	}
	
	public void editUser(){
		
	}
	
}
