package com.visitek.xyzproject.service;

import com.visitek.xyzproject.ejb.RoleLocalService;
import com.visitek.xyzproject.model.business.Role;



public class RoleService extends BaseService<Role> implements RoleLocalService{

	public Role addRole(String rolename) {
		Role r = new Role(rolename);
		getEntityManager().persist(r);	
		return r;		
	}

	
}
