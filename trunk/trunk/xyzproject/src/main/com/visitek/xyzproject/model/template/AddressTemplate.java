package com.visitek.xyzproject.model.template;

import com.visitek.xyzproject.app.Constants;
import com.visitek.xyzproject.model.entity.Address;

public class AddressTemplate extends Address {
	private static final long serialVersionUID = 1L;
	
	static {
		Address tmp = (Address)Constants.em.find(Address.class,-1);
		
		street = tmp.getStreet();
		zipCode = tmp.getZipCode();		
		city = (tmp.getCity());		
		country = tmp.getCountry();
		state = tmp.getState();
		location = tmp.getLocation();
		url = tmp.getUrl();
		email = tmp.getEmail();
		phoneNo = tmp.getPhoneNo();
		faxNo 	= tmp.getFaxNo();	
		mobileNo = tmp.getMobileNo();					
	}


	public Address newAddress() {
		return this;
	}
}
