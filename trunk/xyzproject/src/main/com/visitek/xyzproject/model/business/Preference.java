package com.visitek.xyzproject.model.business;

import com.visitek.xyzproject.model.AbstractPersistentClass;

public class Preference extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	User user;
	Role role;
	int order;
	String prefName;
	String prefValue;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public String getPrefValue() {
		return prefValue;
	}

	public void setPrefValue(String prefValue) {
		this.prefValue = prefValue;
	}

}
