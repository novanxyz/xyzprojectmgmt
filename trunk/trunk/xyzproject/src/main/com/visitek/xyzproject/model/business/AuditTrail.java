package com.visitek.xyzproject.model.business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
@Table(name = "auditrails")
public class AuditTrail extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	Date timestamp;
	User user;
	String action = "update";
	String module;
	Long moduleId;

	Object oldValue;
	Object newValue;
	String field;

	public AuditTrail() {
		super();
		this.timestamp = new Date();
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

	public Long getModuleId() {
		return moduleId;
	}

	public Object getNewValue() {
		return newValue;
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

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public void setNewValue(Object newValue) {
		this.newValue = newValue;
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
				+ " module " + module + "@ moduleId=" + moduleId + " ]";
	}

}
