package com.visitek.xyzproject.model.business;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
@Table(name = "roles")
public class Role extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addUserRole(User user){
		user.getRoles().add(this);		
	}
	public void removeUserRole(User user){
		user.getRoles().remove(this);
	}
	
}
