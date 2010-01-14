package com.visitek.jproject.model.business;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.visitek.jproject.model.AbstractPersistentClass;

@Entity
@Table(name = "auditrails")
public class AuditTrail extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;
    
	Date timestamp;
	User user;
	String action = "update";
	String module;
	Long   moduleId;

	Object oldValue;
	Object newValue;
	String field;
    
    
    
    public AuditTrail() {
    	super();
    	this.timestamp = new Date();
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
	
    
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public Object getOldValue() {
        return oldValue;
    }
    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }
    public Object getNewValue() {
        return newValue;
    }
    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    
    @Override
    public String toString() {
	return "AuditTrail [ " + timestamp + ", " + user + " " + action + " module " + module 
		+ "@ moduleId=" + moduleId + " ]";
    }

    
}
