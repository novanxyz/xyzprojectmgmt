package com.visitek.xyzproject.model.entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

public class Inventory extends AbstractPersistentClass implements IResource {
	private static final long serialVersionUID = 1L;
	
	float cost;
	float load;
	String name;
	String type;
	

	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(float cost, float load, String name, String type) {
		super();
		this.cost = cost;
		this.load = load;
		this.name = name;
		this.type = type;
	}

	public float getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getLoad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return "Inventory";
	}

	public void setCost(float cost) {
		// TODO Auto-generated method stub

	}

	public void setLoad(float load) {
		// TODO Auto-generated method stub

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

}
