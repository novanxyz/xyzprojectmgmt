package com.visitek.xyzproject.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.visitek.xyzproject.model.business.Role;

@Stateless
@Local
public interface RoleLocalService {

	public Role addRole(String rolename);	
}
