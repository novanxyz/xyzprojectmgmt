//$Id: TestCase.java 11282 2007-03-14 22:05:59Z epbernard $
package com.visitek.xyzproject.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Environment;
import org.hibernate.ejb.HibernatePersistence;


/**
 * @author Emmanuel Bernard
 */
public abstract class TestCase extends junit.framework.TestCase {
	protected EntityManagerFactory factory;

	public TestCase() {
		super();
	}

	public TestCase(String name) {
		super( name );
	}

	@SuppressWarnings("deprecation")
	public void setUp() {
		factory = new HibernatePersistence().createEntityManagerFactory( getConfig() );
	}

	public void tearDown() {
		factory.close();
	}

	public abstract Class[] getAnnotatedClasses();

	public String[] getEjb3DD() {
		return new String[] {};
	}

	public Map<Class, String> getCachedClasses() {
		return new HashMap<Class, String>();
	}

	public Map<String, String> getCachedCollections() {
		return new HashMap<String, String>();
	}

	public static Properties loadProperties() {
		Properties props = new Properties();
		try {
		InputStream stream = Persistence.class.getResourceAsStream( "D:/WORK/VISITEK/workspace/xyzprojecet/hibernate-console.properties" );
		if ( stream != null ) {
			try {
				props.load( stream );
			}
			catch (Exception e) {
				throw new RuntimeException( "could not load hibernate.properties" );
			}
			finally {
				try {
					stream.close();
				}
				catch (IOException ioe) {
				}
			}
		}
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		props.setProperty( Environment.HBM2DDL_AUTO, "create-drop" );
		System.out.println(props.toString());
		return props;
	}

	public Map getConfig() {
		Map config = loadProperties();
		ArrayList<Class> classes = new ArrayList<Class>();

		for ( Class clazz : getAnnotatedClasses() ) {
			classes.add( clazz );
		}
		config.put( HibernatePersistence.LOADED_CLASSES, classes );
		for ( Map.Entry<Class, String> entry : getCachedClasses().entrySet() ) {
			config.put(
					HibernatePersistence.CLASS_CACHE_PREFIX + "." + entry.getKey().getName(),
					entry.getValue()
			);
		}
		for ( Map.Entry<String, String> entry : getCachedCollections().entrySet() ) {
			config.put(
					HibernatePersistence.COLLECTION_CACHE_PREFIX + "." + entry.getKey(),
					entry.getValue()
			);
		}
		if ( getEjb3DD().length > 0 ) {
			ArrayList<String> dds = new ArrayList<String>();
			for ( String dd : getEjb3DD() ) {
				dds.add( dd );
			}
			config.put( HibernatePersistence.XML_FILE_NAMES, dds );
		}
		return config;
	}
}
