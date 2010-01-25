package com.visitek.xyzproject.model.entity;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
public class Address extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	protected static String street;

	protected static String city;

	protected static String state;

	protected static String country;

	protected static String zipCode;

	protected static String phoneNo;

	protected static String mobileNo;

	protected static String faxNo;

	protected static String email;

	protected static String url;

	protected static String location;

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

	public  void setCity(String city) {
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

	@Override
	public String toString() {
		return "Address " + street + "\n" + "\n" + city + ", " + state + " "
				+ zipCode + "\n" + country + "\nemail: " + email
				+ "\twebsite: " + url;
	}

}
