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

	public void setCity(String city) {
		Address.city = city;
	}

	public void setCountry(String country) {
		Address.country = country;
	}

	public void setEmail(String email) {
		Address.email = email;
	}

	public void setFaxNo(String faxNo) {
		Address.faxNo = faxNo;
	}

	public void setLocation(String location) {
		Address.location = location;
	}

	public void setMobileNo(String mobileNo) {
		Address.mobileNo = mobileNo;
	}

	public void setPhoneNo(String phoneNo) {
		Address.phoneNo = phoneNo;
	}

	public void setState(String state) {
		Address.state = state;
	}

	public void setStreet(String street) {
		Address.street = street;
	}

	public void setUrl(String url) {
		Address.url = url;
	}

	public void setZipCode(String zipCode) {
		Address.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address " + street + "\n" + "\n" + city + ", " + state + " "
				+ zipCode + "\n" + country + "\nemail: " + email
				+ "\twebsite: " + url;
	}

}
