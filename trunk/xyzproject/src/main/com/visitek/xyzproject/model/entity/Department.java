package com.visitek.xyzproject.model.entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;
import com.visitek.xyzproject.model.business.User;


public class Department extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	Address address;
	User owner;
	Department parent;
	Company company;
	String description;

	public Address getAddress() {
		return address;
	}

	public Company getCompany() {
		return company;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
	}

	public Department getParent() {
		return parent;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

}
