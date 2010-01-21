package com.visitek.xyzproject.model.business;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
public class AccessControlList extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;

	public static final int ACL_LEVEL_MODULE = 0;
	public static final int ACL_LEVEL_OBJECT = 1;
	public static final int ACL_LEVEL_PROPERTY = 2;
    
    User user;
    Role role;
    int level;
    String ObjectId;    // blank untuk semua
    String ObjectAcl;	// blank meants not for all
    
    
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
