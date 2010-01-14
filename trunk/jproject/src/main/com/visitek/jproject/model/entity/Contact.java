package com.visitek.jproject.model.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.visitek.jproject.model.AbstractPersistentClass;

@Entity
@Table(name = "contacts")
public class Contact extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "contact_first_name")
	String firstname;
    @Column(name = "contact_last_name")
	String lastname;
    @Column(name = "contact_order_by")
	String orderby;
    @Column(name = "contact_title")
	String title;
    @Column(name = "contact_job")
	String job;
    
    @OneToOne
    Address address;
    
    Company company;
    
    Department department;
    
    Date birthday;

    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
	
	return firstname + " " + lastname ;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Department getDepartement() {
        return department;
    }

    public void setDepartement(Department departement) {
        this.department = departement;
    }
    
    
   
    
    
}
