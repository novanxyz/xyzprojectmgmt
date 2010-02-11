package com.visitek.xyzproject.service;

import com.visitek.xyzproject.model.business.Action;
import com.visitek.xyzproject.service.exception.PermissionExeption;
import com.visitek.xyzproject.util.Permission;

public class ActionService {
	
	
	/**
	 * @throws PermissionExeption  
	 */
	public boolean checkPermission(Action act) throws PermissionExeption{
		
		
		Permission perms = new Permission(act.getActor());
		
		
		return true;
	}
	
	public void execute(Action act){
		
	}

}
