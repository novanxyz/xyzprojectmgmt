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
    public Contact getOwner() {
        return owner;
    }
    public void setOwner(Contact owner) {
        this.owner = owner;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    

}
