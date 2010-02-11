package com.visitek.xyzproject.model.entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class Address extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	protected String street;
	protected String city;
	protected String state;
	protected String country;
	protected String zipCode;
	protected String phoneNo;
	protected String mobileNo;
	protected String faxNo;
	protected String email;
	protected String url;
	protected String location;

	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String state, String country,
			String zipCode, String phoneNo, String mobileNo, String faxNo,
			String email, String url, String location) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.mobileNo = mobileNo;
		this.faxNo = faxNo;
		this.email = email;
		this.url = url;
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public String getLocation() {
		return location;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getState() {
		return state;
	}

	public String getStreet() {
		return street;
	}

	public String getUrl() {
		return url;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String[] langlot(){		
		return location.split(",");
	}

	@Override
	public String toString() {
		return "Address " + street + "\n" + "\n" + city + ", " + state + " "
				+ zipCode + "\n" + country + "\nemail: " + email
				+ "\twebsite: " + url;
	}
}
