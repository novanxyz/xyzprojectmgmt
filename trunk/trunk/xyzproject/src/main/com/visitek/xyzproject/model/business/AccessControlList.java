package com.visitek.xyzproject.model.business;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class AccessControlList extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	public static final int ACL_LEVEL_MODULE = 0;
	public static final int ACL_LEVEL_OBJECT = 1;
	public static final int ACL_LEVEL_PROPERTY = 2;

	public static final int ACL_PERMISSION_VIEW = 1;
	public static final int ACL_PERMISSION_EDIT = 2;
	public static final int ACL_PERMISSION_ADD = 4;
	public static final int ACL_PERMISSION_DELETE = 8;

	User user;
	Role role;
	int level;
	String ObjectId; // blank untuk semua
	int ObjectAcl; // blank meants not for all

	public AccessControlList() {
		super();	
	}

	public AccessControlList(User user, Role role, int level, String objectId,
			int objectAcl) {
		super();
		this.user = user;
		this.role = role;
		this.level = level;
		ObjectId = objectId;
		ObjectAcl = objectAcl;
	}

	public int getLevel() {
		return level;
	}

	public int getObjectAcl() {
		return ObjectAcl;
	}

	public String getObjectId() {
		return ObjectId;
	}

	public Role getRole() {
		return role;
	}

	public User getUser() {
		return user;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setObjectAcl(int objectAcl) {
		ObjectAcl = objectAcl;
	}

	public void setObjectId(String objectId) {
		ObjectId = objectId;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
