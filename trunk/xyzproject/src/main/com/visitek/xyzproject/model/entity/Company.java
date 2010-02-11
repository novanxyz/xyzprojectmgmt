package com.visitek.xyzproject.model.entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class Company extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	Address address;

	Contact owner;
	String color;
	String description;
	
	public Company() {super();	}
	public Company(String name ) {
		super();	
		this.name = name;
	}

	public Company(String name, Address address, Contact owner, String color,
			String description) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.color = color;
		this.description = description;
	}

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
