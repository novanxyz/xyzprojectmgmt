package com.visitek.xyzproject.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.visitek.xyzproject.model.business.AccessControlList;
import com.visitek.xyzproject.util.db.DBUtil;


public class Constants {
	public static final String  DEFAULT_PROPERTIES_FILE_NAME = "xyzxyzproject.properties";
	
	public static final String CFG_DEFAULTDATEFORMAT = "config.locale.defaultdateformat";
	public static final String CFG_DEFAULTDATETIMEFORMAT = "config.locale.defaultdatetimeformat";
	public static final String CFG_PERSISTENCE_UNIT_NAME = "persistence.jndi.entityManagerFactory";
	public static final String CFG_SESSION_FACTORY_NAME = "hibernate.sessionFactory";
	public static final String CFG_DATASOURCE_JNDI_NAME = "hibernate.jndi.datasourcename";
		
	
	public static final String jpaUnitName = "java:comp/env/xyzproject/pu";
	
	public static final String defaultDateFormat = "ddMMyyyy";
	public static final String defaultDateTimeFormat = "ddMMyyyy HH:mm";
	public static SimpleDateFormat dateformater = null;
	
	
	public static final DBUtil database = null;
	public static final Configuration config=null;
	public static final boolean testMode = true;
	public static EntityManager em ;

	public static boolean defaultAddPermission ;
	public static boolean defaultViewPermission ;
	public static boolean defaultEditPermission ;
	public static boolean defaultDeletePermission ;

	public static Map<String, String> defaultPropertyPermission;
	public static Map<String, String> defaultModulePermission;
	public static Map<String, String> defaultObjectPermission;
	public static List<AccessControlList> defaultPermission = null;

	private static final String LOG4J_PROPERTIES_FILE_NAME = "log4j.properties";

	private static final String LOGGER = "com.visitek.xyzproject";
	public static Logger logger = null;
	
	
	static {
		
	  //try {
		
		  try {
	    		Properties props = new Properties();
	    		
	    		try {
	    			// try to load from current dir
					InputStream is = new FileInputStream(new File(LOG4J_PROPERTIES_FILE_NAME));
					props.load(is);
	    		}
	    		catch(Exception ex) {
	    			// try to load from resource
	    			try {
	    	    		InputStream is = Constants.class.getClassLoader().getResourceAsStream(LOG4J_PROPERTIES_FILE_NAME);
	    	    		props.load(is);
	    			}
	    			catch(Exception ex2) {
	    				ex.printStackTrace();
	    			}
	    		}	    		
	    		PropertyConfigurator.configure(props);	    		
	    		logger = Logger.getLogger(LOGGER);
	        }
	        catch(Exception ex){
	            ex.printStackTrace();
	        }
		  
		  
		
		Properties props = new Properties();		
		try {
			// try to load from current dir
			InputStream is = new FileInputStream(new File(DEFAULT_PROPERTIES_FILE_NAME));
			props.load(is);
		}
		catch(Exception ex) {
			// configuration file not found as resource, try to load from current directory
			try {
				InputStream is = Constants.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE_NAME);
				props.load(is);
			}
			catch(Exception ex2) {
				ex.printStackTrace();
			}
		}
		
		
			
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory(jpaUnitName);		
		em = emf.createEntityManager();
		
		logger.info("entity Manager : " + em.toString() + " " + em.isOpen());
		
		
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
		
	  //}catch (Exception ex) {
      //    ex.printStackTrace();		  
	  //}	
	}
	 
	
}
