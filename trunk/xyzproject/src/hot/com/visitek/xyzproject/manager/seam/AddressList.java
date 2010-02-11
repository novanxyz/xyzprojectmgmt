package com.visitek.xyzproject.manager.seam;

import java.util.Arrays;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityQuery;

import com.visitek.xyzproject.model.entity.Address;

@Name("addressList")
@Scope(ScopeType.SESSION)
public class AddressList extends EntityQuery<Address>{
	
	private static final String EJBQL = "select addr from Address addr";

	private static final String[] RESTRICTIONS = {	
		"lower(addr.street) like lower(concat(#{AddressList.strcriteria},'%'))",
		"lower(addr.city) like lower(concat(#{AddressList.strcriteria},'%'))",
		"lower(addr.country) like lower(concat(#{AddressList.strcriteria},'%'))",
		"lower(addr.url) like lower(concat(#{AddressList.strcriteria},'%'))",
		"lower(addr.zipCode) like lower(concat(#{AddressList.numcriteria},'%'))" ,
		"lower(addr.phoneNo) like lower(concat(#{AddressList.numcriteria},'%'))" ,
		"lower(addr.faxNo) like lower(concat(#{AddressList.numcriteria},'%'))" ,
		"lower(addr.mobileNo) like lower(concat(#{AddressList.numcriteria},'%'))" ,
			};
	
	private Address addr = new Address();
	
	@RequestParameter
	String strcriteria = "";
	@RequestParameter
	String numcriteria = "";
	

	public AddressList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setRestrictionLogicOperator("or");
		setMaxResults(25);
	}


	public String getStrcriteria() {
		return strcriteria;
	}


	public void setStrcriteria(String strcriteria) {
		this.strcriteria = strcriteria;
	}


	public String getNumcriteria() {
		return numcriteria;
	}


	public void setNumcriteria(String numcriteria) {
		this.numcriteria = numcriteria;
	}
	
    
}
