package com.visitek.xyzproject.model.entity;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.IPersistentObject;
@Entity
public interface IResource extends IPersistentObject {
	
	
	public String getName();
	public int getType();	
	public float getLoad();
	public void setLoad(float load);
	public float getCost();
	public void setCost(float cost);
}
