/**
 * @author R. Ardhian (rardhian@gmail.com)
 * April 2007
 */

package com.visitek.jproject.util.db;


import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements DBUtil{
	static final String HIBERNATE_SESSION_FACTORY_JNDI = "hibernate/SessionFactory";
	static Logger logger = Logger.getLogger(HibernateUtil.class);
	
	static final String CONF_SERVER_MODE = "server.mode";
	static boolean serverMode;

	static SessionFactory sessionFactory;
	
	public void initialize(boolean serverMode) {
		HibernateUtil.serverMode = serverMode;

		if(!serverMode) logger.warn("Hibernate SessionFactory is not running in server mode");
	}
	
	public Session getCurrentSession() {
	    Session sess = getSessionFactory().getCurrentSession();
	    
	    logger.debug("Current Session:"+sess.hashCode());
	    return sess;
	}
	
	public static SessionFactory getSessionFactory() {
		boolean rebuildSessionFactory = false;
		
		if(sessionFactory == null) {
			if(serverMode) {
				try {
					Context ctx = new InitialContext();
					sessionFactory = (SessionFactory) ctx.lookup(HIBERNATE_SESSION_FACTORY_JNDI);
					
					return sessionFactory;
					//if(sf == null) throw new NamingException();
				}
				catch(NamingException ex) {
					rebuildSessionFactory = true;
				}
			}
			else {
				rebuildSessionFactory = true;
			}
		}
		else if(sessionFactory.isClosed()) {
			rebuildSessionFactory = true;
		}
		
		if(rebuildSessionFactory) {
			return buildSessionFactory();
		}
		
		return sessionFactory;
	}
		
	public static SessionFactory buildSessionFactory() {
		logger.warn("Attempting to (re)initialize Hibernate SessionFactory");
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}
	
	public static void destroy() {
		
	}

	public void delete(Object entity) {		
		getCurrentSession().delete(entity);		
	}

	public List query(String query) {	
		return getCurrentSession().createSQLQuery(query).list();		
	}

	public void save(Object entity) {
		getCurrentSession().save(entity);
	}

	public void update(Object entity) {
		getCurrentSession().update(entity);		
	}

	public Object load(Class classname, Serializable id) {		
		return getCurrentSession().load(classname, id);		
	}

	public Query namedQuery(String queryname) {
		
		return	(Query) getCurrentSession().getNamedQuery(queryname);
				
	}

	@SuppressWarnings("deprecation")
	public Connection getConnection() {
		return getCurrentSession().connection();		
	}

	
	
	
	
}