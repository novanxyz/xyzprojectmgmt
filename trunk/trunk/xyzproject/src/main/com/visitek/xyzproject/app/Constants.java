package com.visitek.xyzproject.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.visitek.xyzproject.util.db.DBUtil;

public class Constants {
	public static final String DEFAULT_PROPERTIES_FILE_NAME = "xyzxyzproject.properties";

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
	public static final Configuration config = null;
	public static final boolean testMode = true;
	public static EntityManager em;

	public static boolean defaultAddPermission;
	public static boolean defaultViewPermission;
	public static boolean defaultEditPermission;
	public static boolean defaultDeletePermission;

	public static Map<String, Integer> defaultPropertyPermission;

	private static final String LOG4J_PROPERTIES_FILE_NAME = "log4j.properties";

	private static final String LOGGER = "com.visitek.xyzproject";
	public static Logger logger = null;

	static {

		// try {

		try {
			Properties props = new Properties();

			try {
				// try to load from current dir
				InputStream is = new FileInputStream(new File(
						LOG4J_PROPERTIES_FILE_NAME));
				props.load(is);
			} catch (Exception ex) {
				// try to load from resource
				try {
					InputStream is = Constants.class.getClassLoader()
							.getResourceAsStream(LOG4J_PROPERTIES_FILE_NAME);
					props.load(is);
				} catch (Exception ex2) {
					ex.printStackTrace();
				}
			}
			PropertyConfigurator.configure(props);
			logger = Logger.getLogger(LOGGER);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Properties props = new Properties();
		try {
			// try to load from current dir
			InputStream is = new FileInputStream(new File(
					DEFAULT_PROPERTIES_FILE_NAME));
			props.load(is);
		} catch (Exception ex) {
			// configuration file not found as resource, try to load from
			// current directory
			try {
				InputStream is = Constants.class.getClassLoader()
						.getResourceAsStream(DEFAULT_PROPERTIES_FILE_NAME);
				props.load(is);
			} catch (Exception ex2) {
				ex.printStackTrace();
			}
		}

		/*
		 * EntityManagerFactory emf =
		 * Persistence.createEntityManagerFactory(jpaUnitName); em =
		 * emf.createEntityManager();
		 */
		logger.info("entity Manager : " + em.toString() + " " + em.isOpen());

		defaultPropertyPermission = new HashMap<String, Integer>();
		defaultPropertyPermission.put("", 1);

		dateformater = new SimpleDateFormat(defaultDateTimeFormat);

		// }catch (Exception ex) {
		// ex.printStackTrace();
		// }
	}

}
