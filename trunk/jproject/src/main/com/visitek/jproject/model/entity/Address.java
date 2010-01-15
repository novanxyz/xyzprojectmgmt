package com.visitek.jproject.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.visitek.jproject.model.AbstractPersistentClass;


@Entity
@Table(name = "addresses")
public class Address extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;
    

	String phoneNo;

	String mobileNo;

	String faxNo;
    String address1;

	String address2;

	String city;

	String state;

	String country;

	String zipCode;

	String email;

	String url;
	
	String location;
	
    public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getFaxNo() {
        return faxNo;
    }
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Override
    public String toString() {	
	return "Address " + address1 + ( address2 != "") != null ? "\n" + address2 : ""
		+ "\n" + city + ", " + state + " " + zipCode 
		+ "\n" + country 
		+ "\nemail: " + email + "\twebsite: " + url;
    }

    
}
