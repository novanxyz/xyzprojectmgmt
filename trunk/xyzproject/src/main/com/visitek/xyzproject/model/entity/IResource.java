package com.visitek.xyzproject.model.entity;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.IPersistentObject;

@Entity
public interface IResource extends IPersistentObject {

	public float getCost();

	public float getLoad();

	public String getName();

	public String getType();

	public void setCost(float cost);

	public void setLoad(float load);
}
