package com.visitek.jproject.model.entity;

import com.visitek.jproject.model.AbstractPersistentClass;

public class CustomField extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;
	
	String parentModule ;
	String parentPropertyName;
	Long parentObjectId;
	
	String childModule;
	Long childObjectId;
	
	
	public String getParentModule() {
		return parentModule;
	}
	public void setParentModule(String parentModule) {
		this.parentModule = parentModule;
	}
	public String getParentPropertyName() {
		return parentPropertyName;
	}
	public void setParentPropertyName(String parentPropertyName) {
		this.parentPropertyName = parentPropertyName;
	}
	public Long getParentObjectId() {
		return parentObjectId;
	}
	public void setParentObjectId(Long parentObjectId) {
		this.parentObjectId = parentObjectId;
	}
	public String getChildModule() {
		return childModule;
	}
	public void setChildModule(String childModule) {
		this.childModule = childModule;
	}
	public Long getChildObjectId() {
		return childObjectId;
	}
	public void setChildObjectId(Long childObjectId) {
		this.childObjectId = childObjectId;
	}
	
	

}
