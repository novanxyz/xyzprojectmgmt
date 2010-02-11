package com.visitek.xyzproject.model.business;
import com.visitek.xyzproject.model.AbstractPersistentClass;



public class Module extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	String description;
	String uiName;

	String entityName;
	boolean uiActive;
	String iconPath;
	String status;
	int 	viewOrder;

	
	public Module(String name) {
		super();
		this.name = name;
	}
	

	public Module(String name, String entityName) {
		super();
		this.name = name;
		this.uiName = name;
		this.entityName = entityName;
	}


	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Module(String name, String description, String uiName,
			String entityName, boolean uiActive, String iconPath,
			String status, int viewOrder) {
		super();
		this.name = name;
		this.description = description;
		this.uiName = uiName;
		this.entityName = entityName;
		this.uiActive = uiActive;
		this.iconPath = iconPath;
		this.status = status;
		this.viewOrder = viewOrder;
	}

	public String getDescription() {
		return description;
	}
	
	public boolean isUiActive(){
			return uiActive;
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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
