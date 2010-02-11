package com.visitek.xyzproject.model.entity;

import java.util.Date;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class Contact extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String firstname;
	String lastname;
	String orderby;
	String title;
	String job;
	Address address = new Address();
	Company company;
	Department department;
	Date birthday ;
	

	public Contact() {	super();}
	
	public Contact(String name, String email){
		super();
		firstname = name.split(" ")[0];
		lastname = name.split(" ")[1];
		setEmail(email);
	}
	

	public Contact(String firstname, String lastname, String orderby,
			String title, String job, Address address, Company company,
			Department department, Date birthday) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.orderby = orderby;
		this.title = title;
		this.job = job;
		this.address = address;
		this.company = company;
		this.department = department;
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	public void setEmail(String email){
		this.getAddress().setEmail(email);
	}
	public String getEmail(){
		return getAddress().getEmail();
	}

	public Company getCompany() {
		return company;
	}

	public Department getDepartement() {
		return department;
	}

	public Department getDepartment() {
		return department;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getJob() {
		return job;
	}

	public String getLastname() {
		return lastname;
	}

	public String getName() {

		return firstname + " " + lastname;
	}

	public String getOrderby() {
		return orderby;
	}

	public String getTitle() {
		return title;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setDepartement(Department departement) {
		this.department = departement;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
