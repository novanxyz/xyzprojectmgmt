package com.visitek.xyzproject.model.entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

public class CustomField extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String parentModule;
	String parentPropertyName;
	Long parentObjectId;

	String childModule;
	Long childObjectId;

	public String getChildModule() {
		return childModule;
	}

	public Long getChildObjectId() {
		return childObjectId;
	}

	public String getParentModule() {
		return parentModule;
	}

	public Long getParentObjectId() {
		return parentObjectId;
	}

	public String getParentPropertyName() {
		return parentPropertyName;
	}

	public void setChildModule(String childModule) {
		this.childModule = childModule;
	}

	public void setChildObjectId(Long childObjectId) {
		this.childObjectId = childObjectId;
	}

	public void setParentModule(String parentModule) {
		this.parentModule = parentModule;
	}

	public void setParentObjectId(Long parentObjectId) {
		this.parentObjectId = parentObjectId;
	}

	public void setParentPropertyName(String parentPropertyName) {
		this.parentPropertyName = parentPropertyName;
	}

}
