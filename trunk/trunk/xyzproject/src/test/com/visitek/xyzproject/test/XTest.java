package com.visitek.xyzproject.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import org.hibernate.cfg.Environment;
import org.hibernate.ejb.HibernatePersistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class XTest extends TestCase{
	
	protected EntityManagerFactory factory;

	public XTest() {
		super();
	}

	public XTest(String name) {
		super( name );
	}

	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		factory = new HibernatePersistence().createEntityManagerFactory( getConfig() );
	}

	@After
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
		InputStream stream = Persistence.class.getResourceAsStream( "/hibernate.properties" );
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
		props.setProperty( Environment.HBM2DDL_AUTO, "create-drop" );
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


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

}
