package com.visitek.jproject.model.business;

import com.visitek.jproject.model.AbstractPersistentClass;

public class AccessControlList extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;

	public static final int ACL_LEVEL_MODULE = 0;
	public static final int ACL_LEVEL_OBJECT = 1;
	public static final int ACL_LEVEL_PROPERTY = 2;
    
    User user;
    Role role;
    int level;
    String ObjectId;    
    String ObjectAcl;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getObjectId() {
		return ObjectId;
	}
	public void setObjectId(String objectId) {
		ObjectId = objectId;
	}
	public String getObjectAcl() {
		return ObjectAcl;
	}
	public void setObjectAcl(String objectAcl) {
		ObjectAcl = objectAcl;
	}
    
	    
}
