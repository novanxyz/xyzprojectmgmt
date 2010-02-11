package com.visitek.xyzproject.ejb;

import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.model.entity.Contact;

public interface UserService {
	public User newUser(String username, String email,String password, Contact contact);
	public User createUserfromContact(Contact contact,String password);
}
