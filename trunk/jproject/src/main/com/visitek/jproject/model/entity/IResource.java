package com.visitek.jproject.model.entity;

import com.visitek.jproject.model.IPersistentObject;

public interface IResource extends IPersistentObject {
	
	
	public String getName();
	public int getType();	
	public float getLoad();
	public void setLoad(float load);
	public float getCost();
	public void setCost(float cost);
}
