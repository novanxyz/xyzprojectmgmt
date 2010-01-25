package com.visitek.xyzproject.model.business;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
@Table(name = "modules")
public abstract class Module extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	String Description;
	String uiName;

	String className;
	String uiActive;
	String iconPath;
	String status;
	int viewOrder;

	@Override
	public String getClassName() {
		return className;
	}

	public String getDescription() {
		return Description;
	}

	public String getIconPath() {
		return iconPath;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getUiActive() {
		return uiActive;
	}

	public String getUiName() {
		return uiName;
	}

	public int getViewOrder() {
		return viewOrder;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUiActive(String uiActive) {
		this.uiActive = uiActive;
	}

	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

	public void setViewOrder(int viewOrder) {
		this.viewOrder = viewOrder;
	}

}
