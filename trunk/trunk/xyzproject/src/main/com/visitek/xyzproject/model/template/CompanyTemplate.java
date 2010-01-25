package com.visitek.xyzproject.model.template;

import com.visitek.xyzproject.model.entity.Company;

public class CompanyTemplate extends Company {
	private static final long serialVersionUID = 1L;

	public Company newCompany() {
		return this;
	}
}
