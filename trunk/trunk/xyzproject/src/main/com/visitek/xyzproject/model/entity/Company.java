package com.visitek.xyzproject.model.entity;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
public class Company extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	Address address;

	Contact owner;
	String color;
	String description;

	public Address getAddress() {
		return address;
	}

	public String getColor() {
		return color;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Contact getOwner() {
		return owner;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Contact owner) {
		this.owner = owner;
	}

}
