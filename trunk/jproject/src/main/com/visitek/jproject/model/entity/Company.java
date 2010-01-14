package com.visitek.jproject.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.visitek.jproject.model.AbstractPersistentClass;

@Entity	
@Table(name = "companies")
public class Company extends AbstractPersistentClass {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "company_name")
	String name;
    @OneToOne
    Address address;
    @Column(name = "company_owner")
	@OneToOne
	Contact owner;
    @Column(name = "company_color")
	String color;
    @Column(name = "company_description")
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
