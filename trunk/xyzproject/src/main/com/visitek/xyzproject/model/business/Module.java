package com.visitek.xyzproject.model.business;
import com.visitek.xyzproject.model.AbstractPersistentClass;



public class Module extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	String description;
	String uiName;

	String className;
	boolean uiActive;
	String iconPath;
	String status;
	int 	viewOrder;

	@Override
	public String getClassName() {
		return className;
	}

	public String getDescription() {
		return description;
	}

	public String getIconPath() {
		if (iconPath == null)
			return "/modules/" + name + "/view/" + name + ".jpg";
		return iconPath;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
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
		this.description = description;
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

	public void setUiActive(boolean uiActive) {
		this.uiActive = uiActive;
	}

	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

	public void setViewOrder(int viewOrder) {
		this.viewOrder = viewOrder;
	}

}
