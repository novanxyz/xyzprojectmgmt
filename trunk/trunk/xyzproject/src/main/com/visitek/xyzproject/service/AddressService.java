package com.visitek.xyzproject.service;

import java.util.List;

import com.visitek.xyzproject.model.entity.Address;
import com.visitek.xyzproject.model.entity.Company;
import com.visitek.xyzproject.model.entity.Contact;
import com.visitek.xyzproject.model.entity.Department;

public class AddressService extends BaseService<Address> {

	public Address findAddress(String addr) {
		try {
			Address ad = (Address) getEntityManager().createNamedQuery(
					"searchaddress").setParameter("addr", addr)
					.getSingleResult();
			return ad;
		} catch (Exception e) {

		}
		return null;
	}

	public List<Address> findAddresses(String addr) {
		try {
			List<Address> ads = getEntityManager().createNamedQuery(
					"searchaddress").setParameter("addr", addr).getResultList();
			return ads;
		} catch (Exception e) {

		}
		return null;
	}

	public List<Company> getCompaniesfromAddresses(String str) {
		try {
			return getEntityManager().createNamedQuery("companybyAddres")
					.setParameter("addr", str).getResultList();
		} catch (Exception e) {
		}

		return null;
	}

	public Company getCompanyfromAddress(String str) {

		try {
			Company comp = (Company) getEntityManager().createNamedQuery(
					"companybyAddres").setParameter("addr", str)
					.getSingleResult();
			return comp;
		} catch (Exception e) {

		}

		return null;
	}

	public Contact getContactfromAddress(String str) {
		try {
			return (Contact) getEntityManager().createNamedQuery(
					"contactbyAddres").setParameter("addr", str)
					.getSingleResult();
		} catch (Exception e) {
		}
		return null;
	}

	public List<Contact> getContactsfromAddresses(String str) {
		try {
			return getEntityManager().createNamedQuery("contactbyAddres")
					.setParameter("addr", str).getResultList();
		} catch (Exception e) {
		}

		return null;
	}

	public Department getDepartmentfromAddress(String str) {
		try {
			return (Department) getEntityManager().createNamedQuery(
					"deptbyAddres").setParameter("addr", str).getResultList();
		} catch (Exception e) {
		}

		return null;
	}

	public List<Department> getDepartmentsfromAddresses(String str) {
		try {
			return getEntityManager().createNamedQuery("deptbyAddres")
					.setParameter("addr", str).getResultList();
		} catch (Exception e) {
		}
		return null;
	}

}
