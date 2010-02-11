package com.visitek.xyzproject.model.business;

import java.util.Date;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class AuditTrail extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	Date timestamp;
	User user;
	String action = "update";
	String module;
	Long objectId;

	Object oldValue;
	Object newValue;
	String field;

	public AuditTrail() {
		super();
		this.timestamp = new Date();
	}
	

	public AuditTrail(Date timestamp, User user, String action, String module,
			Long objectId, Object oldValue, Object newValue, String field) {
		super();
		this.timestamp = timestamp;
		this.user = user;
		this.action = action;
		this.module = module;
		this.objectId = objectId;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.field = field;
	}


	public String getAction() {
		return action;
	}

	public String getField() {
		return field;
	}

	public String getModule() {
		return module;
	}

	public Object getNewValue() {
		return newValue;
	}

	public Long getObjectId() {
		return objectId;
	}

	public Object getOldValue() {
		return oldValue;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuditTrail [ " + timestamp + ", " + user + " " + action
				+ " module " + module + "#objectId=" + objectId + " ]";
	}

}
