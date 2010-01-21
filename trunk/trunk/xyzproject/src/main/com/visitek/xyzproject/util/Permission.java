package com.visitek.xyzproject.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.visitek.xyzproject.app.Constants;
import com.visitek.xyzproject.model.business.AccessControlList;
import com.visitek.xyzproject.model.business.Role;
import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.service.UserSessionService;

public class Permission {
		
	
	private static Map<String,String> propertyAcl;
	
	
	static User actor;	
	static {	
		
		propertyAcl = Constants.defaultPropertyPermission;
				
		List<AccessControlList> perms = new ArrayList<AccessControlList>();
		
		User user = UserSessionService.getCurrentUser(null);
		
		if (user.equals(null)){			
			perms = Constants.defaultPermission;
		}else{
			
		  try {
			perms = Constants.em.createNamedQuery("getUserPermission")
								.setParameter("user_id", user.getId())								
								.getResultList();
			actor  = user;
			
			Set<Role> group = user.getRoles();			
			Iterator it = group.iterator();
			
			while (it.hasNext()){
				Role r = (Role)it.next();				
				perms.addAll(
						Constants.em.createNamedQuery("getRolePermission")
						.setParameter("role_id", r.getId())
						.setParameter("user_id", user.getId())
						.getResultList() 
				);				
			}
		  } catch (Exception e) {
			
		  }
		}
				
		Iterator<AccessControlList> it = perms.iterator();
		
		while (it.hasNext()){
			AccessControlList acl = it.next();
			propertyAcl.put(acl.getObjectId(),acl.getObjectAcl());
		}
		
	}
			
	public Permission(User user) {		
		
		propertyAcl = new HashMap<String,String>();
		List<AccessControlList> perms = new ArrayList<AccessControlList>();
		
		if (user.equals(null)){			
			perms = Constants.defaultPermission;
		}else{
			
		  try {
			perms = Constants.em.createNamedQuery("getUserPermission")
								.setParameter("user_id", user.getId())								
								.getResultList();
			actor  = user;
			
			Set<Role> group = user.getRoles();
			
			Iterator it = group.iterator();
			
			while (it.hasNext()){
				Role r = (Role)it.next();				
				perms.addAll(
						Constants.em.createNamedQuery("getRolePermission")
						.setParameter("role_id", r.getId())
						.setParameter("user_id", user.getId())
						.getResultList() 
				);				
			}
		  } catch (Exception e) {
			
		  }
		}
		
		
		Iterator<AccessControlList> it = perms.iterator();
		
		while (it.hasNext()){
			AccessControlList acl = it.next();
			propertyAcl.put(acl.getObjectId(),acl.getObjectAcl());
		}
				
	}
	
	public boolean checkView(String module,String oid,String property){
		oid = (oid ==null || oid.length()==0 )? "":"#"+ oid;
		property = (property == null || property.length()==0 )? "":"."+property;

		boolean test = Constants.defaultViewPermission;
		
		if (test && propertyAcl.containsKey(module+property+oid) ) {
			test =  propertyAcl.get(property).equals("v");
		}
		return test;
	}
	
	public boolean checkAdd(String module,String oid,String property){
		oid = (oid ==null || oid.length()==0 )? "":"#"+ oid;
		property = (property == null || property.length()==0 )? "":"."+property;

		boolean test = Constants.defaultAddPermission;
				
		if (test && propertyAcl.containsKey(module+property+oid) ) {
			test =  propertyAcl.get(property).indexOf("a")>-1;
		}
		return test;
	}
	
	public boolean checkEdit(String module,String oid,String property){
		oid = (oid ==null || oid.length()==0 )? "":"#"+ oid;
		property = (property == null || property.length()==0 )? "":"."+property;

		
		boolean test = Constants.defaultEditPermission;			
		if (test && propertyAcl.containsKey(module+property+oid) ) {
			test =  propertyAcl.get(property).indexOf("v")>-1 ;
		}		
		return test;
	}
	
	public boolean checkDelete(String module,String oid,String property){
		
		boolean test = Constants.defaultDeletePermission;
		
		if (test && propertyAcl.containsKey(module+property+oid) ) {
			test =  propertyAcl.get(property).indexOf("d")>-1; 
		}		
		return test;
	}
	
	public void addUserPermission(User user, String module,  String oid, String property, String aclstr){

				//check exist  ?

		if (user.equals(actor) || user.equals(null)){			
			if (aclstr.indexOf("a")>-1 && checkAdd(module, oid, property)){			
				aclstr.replace("a", "");
			}
			if (aclstr.indexOf("v")>-1 && checkView(module, oid, property)){
				aclstr.replace("v", "");
			}
			if (aclstr.indexOf("e")>-1 && checkEdit(module, oid, property)){
				aclstr.replace("e", "");
			}
			if (aclstr.indexOf("d")>-1 && checkDelete(module, oid, property)){
				aclstr.replace("d", "");
			}
		}
		
		try{
			AccessControlList acl ;
			oid = (oid==null || oid.length()>0)? "":"#"+oid;
			property = (oid==null || property.length()>0)? "":"."+property;
		
			try {
				
			acl = (AccessControlList) Constants.em.createNamedQuery("getPermissionUser")
												.setParameter("user_id", user.getId())
												.setParameter("obj",module+property+oid)
												.getSingleResult();
			
			
			acl.setObjectAcl( acl.getObjectAcl()+ aclstr );			
			
			}catch (Exception noex){
				
				acl = new AccessControlList();
				acl.setUser(null);
				acl.setObjectId(module+property+oid);
				acl.setObjectAcl(aclstr);						
			}
			
			Constants.em.persist(acl);
			propertyAcl.put(acl.getObjectId(), acl.getObjectAcl() );
			
		}catch (Exception ex){
			
		}
		
	}

	public void addRolePermission(Role role, String module, String property, String oid, String aclstr){
		 
		// check exist ?
		oid = (oid==null || oid.length() > 0)? "":"#"+oid;
		property = (oid==null || property.length()>0)? "":"."+property;
		
		List<AccessControlList> perms  = Constants.em.createNamedQuery("getRolePermission")
										.setParameter("role_id", role.getId())
										.setParameter("user_id", null)
										.getResultList();
		
		Iterator<AccessControlList> Itacls = perms.iterator();
		
		while (Itacls.hasNext()){
			AccessControlList acl = Itacls.next();
			if (acl.getObjectId().equals(module+property+oid)){
				// ?????
				if (aclstr.equals(acl.getObjectAcl())) return;
				acl.setObjectAcl(aclstr + acl.getObjectAcl());
				Constants.em.persist(acl);
			}
		}
	}
	public void addUserRolePermission(Role role,User user, String module, String property, String oid, String aclstr){
		 
		// check exist ?
		oid = (oid==null || oid.length() > 0)? "":"#"+oid;
		property = (oid==null || property.length()>0)? "":"."+property;
		
		List<AccessControlList> perms  = Constants.em.createNamedQuery("getRolePermission")
										.setParameter("role_id", role.getId())
										.setParameter("user_id", user.getId())
										.getResultList();
		
		Iterator<AccessControlList> Itacls = perms.iterator();
		
		while (Itacls.hasNext()){
			AccessControlList acl = Itacls.next();
			if (acl.getObjectId().equals(module+property+oid)){
				// ?????
				if (aclstr.equals(acl.getObjectAcl())) return;
				acl.setObjectAcl(aclstr + acl.getObjectAcl());
				Constants.em.persist(acl);				
			}							
		}
	}
	
	public void deleteUserPermission(User user, String module, String property, String oid){
		oid = (oid==null || oid.length() > 0)? "":"#"+oid;
		property = (oid==null || property.length()>0)? "":"."+property;
		
		
		try {
			AccessControlList acl = (AccessControlList) Constants.em.createNamedQuery("getPermissionUser")
			.setParameter("user_id", user.getId())
			.setParameter("obj",module+property+oid)
			.getSingleResult();			
			Constants.em.remove(acl);
		}catch (Exception e) {
			
		}
		
		
	}
	
	public void deleteRolePermission(Role role, String module, String property, String oid){
		
		oid = (oid==null || oid.length() > 0)? "" : "#"+oid;
		property = (oid==null || property.length()>0)? "" : "." + property;				
		try {
			AccessControlList acl = (AccessControlList) Constants.em.createNamedQuery("getPermissionRole")
			.setParameter("role_id", role.getId())
			.setParameter("obj",module+property+oid)
			.getSingleResult();
			
			Constants.em.remove(acl);
		}catch (Exception e) {
			
		}
		
		
	}
	
	
		
		
		
		
	
	
}
