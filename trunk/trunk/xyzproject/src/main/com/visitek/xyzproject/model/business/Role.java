package com.visitek.xyzproject.model.business;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
public class Role extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;

	public Role(String name2) {
		name = name2;
	}

	public void addUserRole(User user) {
		user.getRoles().add(this);
	}

	public String getName() {
		return name;
	}

	public void removeUserRole(User user) {
		user.getRoles().remove(this);
	}

	public void setName(String name) {
		this.name = name;
	}

}
