package com.visitek.xyzproject.model.entity;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;


@Entity
public class Address extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;
    

    String street;
	

	String city;

	String state;

	String country;

	String zipCode;
    
	String phoneNo;

	String mobileNo;

	String faxNo;

	String email;

	String url;
	
	String location;
	
	    
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
	return "Address " + street +  "\n"
		+ "\n" + city + ", " + state + " " + zipCode 
		+ "\n" + country 
		+ "\nemail: " + email + "\twebsite: " + url;
    }

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

    
}
