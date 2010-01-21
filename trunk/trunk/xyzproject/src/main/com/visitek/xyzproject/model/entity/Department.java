package com.visitek.xyzproject.model.entity;


import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;
import com.visitek.xyzproject.model.business.User;

@Entity
public class Department extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;

   
	String name;
    Address address;
    User owner;
    Department parent;    
    Company company;
    String description;    
    
    public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Company getCompany() {
	return company;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }


    public Address getAddress() {
        return address;
    }



    public void setAddress(Address address) {
        this.address = address;
    }



    public User getOwner() {
        return owner;
    }



    public void setOwner(User owner) {
        this.owner = owner;
    }



    public Department getParent() {
        return parent;
    }



    public void setParent(Department parent) {
        this.parent = parent;
    }



    public void setCompany(Company company) {
        this.company = company;
    }
    

}
