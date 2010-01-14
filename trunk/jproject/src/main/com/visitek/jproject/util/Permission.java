package com.visitek.jproject.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.visitek.jproject.app.Constants;
import com.visitek.jproject.model.AbstractPersistentClass;
import com.visitek.jproject.model.business.AccessControlList;
import com.visitek.jproject.model.business.Role;
import com.visitek.jproject.model.business.User;

@Entity
@Table(name = "permissions")
public class Permission extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;
	
	
	
	private static Map<String,String> moduleAcl;
	private static Map<String,String> propertyAcl;
	private static Map<String,String> objectAcl;
	
	
	static {
		moduleAcl = Constants.defaultModulePermission;
		propertyAcl = Constants.defaultPropertyPermission;
		objectAcl = Constants.defaultObjectPermission;
		
	}
			
	public Permission(User user) {		
		
		
		moduleAcl = new HashMap<String,String>();
		propertyAcl = new HashMap<String,String>();
		objectAcl = new HashMap<String,String>();
		
		
		List<AccessControlList> perms =null;
		
		if (user == null){			
			perms = Constants.defaultPermission;
		}else{
			perms = Constants.em.createNamedQuery("getPermission")
								.setParameter("user_id", user.getId())
								.setParameter("group_id", user.getRole().getId())
								.getResultList();
		}
		
		
		Iterator<AccessControlList> it = perms.iterator();
		
		while (it.hasNext()){
			AccessControlList acl = it.next();
			if (acl.getLevel()== AccessControlList.ACL_LEVEL_MODULE){
				moduleAcl.put(acl.getObjectId(),acl.getObjectAcl());
				
			}else if (acl.getLevel() == AccessControlList.ACL_LEVEL_PROPERTY){
				propertyAcl.put(acl.getObjectId(),acl.getObjectAcl());
			}else {
				objectAcl.put(acl.getObjectAcl(), acl.getObjectAcl());
			}
		}
					
	}
	
	public boolean checkView(String module,String property,String oid){
		
		boolean test = Constants.defaultViewPermission;
		
		if (test || moduleAcl.containsKey(module)) {
			 test = moduleAcl.get(module).equals("v");	
		}
		
		if (test && objectAcl.containsKey(oid)) {
			test =  objectAcl.get(oid).equals("v");
		}
		
		if (test && propertyAcl.containsKey(property) ) {
			test =  propertyAcl.get(property).equals("v");
		}		
		return test;
	}
	
	public boolean checkAdd(String module,String property,String oid){
		
		boolean test = Constants.defaultAddPermission;
		if (test || moduleAcl.containsKey(module)) {
			 test = moduleAcl.get(module).equals("a");	
		}
		
		if (test && objectAcl.containsKey(oid)) {
			test =  objectAcl.get(oid).equals("a");
		}
		
		if (test && propertyAcl.containsKey(property) ) {
			test =  propertyAcl.get(property).equals("a");
		}		
		return test;
	}
	
	public boolean checkEdit(String module,String property,String oid){
		boolean test = Constants.defaultEditPermission;
		
		if (test || moduleAcl.containsKey(module)) {
			 test = moduleAcl.get(module).equals("v");	
		}
		
		if (test && objectAcl.containsKey(oid)) {
			test =  objectAcl.get(oid).equals("v");
		}
		
		if (test && propertyAcl.containsKey(property) ) {
			test =  propertyAcl.get(property).equals("v");
		}		
		return test;
	}
	
	public boolean checkDelete(String module,String property,String oid){
		
		boolean test = Constants.defaultDeletePermission;
		if (test || moduleAcl.containsKey(module)) {
			 test = moduleAcl.get(module).equals("d");	
		}
		
		if (test && objectAcl.containsKey(oid)) {
			test =  objectAcl.get(oid).equals("d");
		}
		
		if (test && propertyAcl.containsKey(property) ) {
			test =  propertyAcl.get(property).equals("d");
		}		
		return test;
	}
	
	public void addUserPermission(User user, String module, String property, String oid, String aclstr){
		
		AccessControlList acl = new AccessControlList();
		acl.setUser(user);
		acl.setRole(null);
		if (!property.equals(null)) {
			acl.setLevel(AccessControlList.ACL_LEVEL_PROPERTY);
			acl.setObjectId(property);
		}else if (!oid.equals(null)){
			acl.setLevel(AccessControlList.ACL_LEVEL_OBJECT);
			acl.setObjectId(oid);
		}else {
			acl.setLevel(AccessControlList.ACL_LEVEL_MODULE);
			acl.setObjectAcl(module);
		}			
		acl.setObjectAcl(aclstr);		
		Constants.em.persist(acl);
	}

	public void addRolePermission(Role role, String module, String property, String oid, String aclstr){
		AccessControlList acl = new AccessControlList();
		
		acl.setRole(role);
		if (!property.equals(null)) {
			acl.setLevel(AccessControlList.ACL_LEVEL_PROPERTY);
			acl.setObjectId(property);
		}else if (!oid.equals(null)){
			acl.setLevel(AccessControlList.ACL_LEVEL_OBJECT);
			acl.setObjectId(oid);
		}else {
			acl.setLevel(AccessControlList.ACL_LEVEL_MODULE);
			acl.setObjectAcl(module);
		}			
		acl.setObjectAcl(aclstr);		
		Constants.em.persist(acl);				
	}
}
