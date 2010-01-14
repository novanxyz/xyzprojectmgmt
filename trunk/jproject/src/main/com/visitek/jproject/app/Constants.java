package com.visitek.jproject.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.visitek.jproject.model.business.AccessControlList;
import com.visitek.jproject.util.db.DBUtil;

public class Constants {
	public static final String JPA_UNITNAME = "jprojectJPAUnit";
	
	public static final String defaultDateFormat = "ddMMyyyy";
	public static final String defaultDateTimeFormat = "ddMMyyyy HH:mm";
	public static final SimpleDateFormat dateformater;
	
	
	public static final DBUtil database = null;
	public static final Configuration config=null;
	public static final boolean testMode = true;
	public static final EntityManager em;

	public static final boolean defaultAddPermission;
	public static final boolean defaultViewPermission;
	public static final boolean defaultEditPermission;
	public static final boolean defaultDeletePermission;

	public static Map<String, String> defaultPropertyPermission;
	public static Map<String, String> defaultModulePermission;
	public static Map<String, String> defaultObjectPermission;
	public static final List<AccessControlList> defaultPermission;
	
	
	static {
		
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory(JPA_UNITNAME);		
		em = emf.createEntityManager();
		
		
		defaultViewPermission = true;
		defaultEditPermission = true;
		defaultDeletePermission = false;
		defaultAddPermission = true;	
		
		defaultObjectPermission = new HashMap<String, String>();
		defaultObjectPermission.put("", "v");
		defaultModulePermission = new HashMap<String, String>();
		defaultModulePermission.put("", "v");
		defaultPropertyPermission.put("","v");
		
		defaultPermission = new ArrayList<AccessControlList>();
		AccessControlList acl = new AccessControlList();
		acl.setLevel(AccessControlList.ACL_LEVEL_MODULE);
		acl.setObjectId("");
		acl.setObjectAcl("v");
		defaultPermission.add(acl);
		acl.setLevel(AccessControlList.ACL_LEVEL_OBJECT);
		defaultPermission.add(acl);
		acl.setLevel(AccessControlList.ACL_LEVEL_PROPERTY);
		defaultPermission.add(acl);
		
		
		dateformater = new SimpleDateFormat(defaultDateTimeFormat);		
		
		
	}
	
}
