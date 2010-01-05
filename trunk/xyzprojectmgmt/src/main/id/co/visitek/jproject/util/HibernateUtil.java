/**
 * @author R. Ardhian (rardhian@gmail.com)
 * April 2007
 */

package id.co.visitek.jproject.util;

import id.co.visitek.jproject.model.object.AbstractPersistentClass;
import id.co.visitek.jproject.model.object.AuditTrail;
import id.co.visitek.jproject.model.object.User;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static final String HIBERNATE_SESSION_FACTORY_JNDI = "hibernate/SessionFactory";
	static Logger logger = Logger.getLogger(HibernateUtil.class);
	
	static final String CONF_SERVER_MODE = "server.mode";
	static boolean serverMode;

	static SessionFactory sessionFactory;
	
	public static void initialize(boolean serverMode) {
		HibernateUtil.serverMode = serverMode;

		if(!serverMode) logger.warn("Hibernate SessionFactory is not running in server mode");
	}
	
	public static Session getCurrentSession() {
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

	public List<AbstractPersistentClass> getList(String module, String criteria){
	    
	    try {
		
		String hql = "from " + module + " where " + criteria;
		List<AbstractPersistentClass> list = getCurrentSession().createQuery(hql).list();
		return list;
		 
	    } catch(HibernateException ex){
		
	    }
	    return null;	    
	}
	
	public List<AbstractPersistentClass> query(String query){
	    
	    try {
		
		return getCurrentSession().getNamedQuery(query).list();
	    } catch(HibernateException ex){
		
	    }
	    return null;	    
	}
	
	
	public List<AbstractPersistentClass> getListofObjects(String module, String criteria){
	    
	    try {
		
		String hql = "from " + module + " where " + criteria;
		return getCurrentSession().createQuery(hql).list();
		 
	    } catch(HibernateException ex){
		
	    }
	    return null;	    
	}
	
	
	
	public AbstractPersistentClass getObject(String module, Long id){
	    
	    try {    
		return (AbstractPersistentClass)getCurrentSession().get(module, id);
	    } catch(HibernateException ex){
		
	    }
	    return null;
	}
	
	public Long saveObject(AbstractPersistentClass object,User user){
	    
	    try {
	    AuditTrail audit = new AuditTrail();	    
	    audit.setAction("add");
	    audit.setModule(object.getClass().getName());
	    audit.setUser(user);
	    audit.setNewValue(object.getId());
	    
	    getCurrentSession().save(object);	    
	    getCurrentSession().save(audit);	    
	    return object.getId(); 	
	    
	    } catch(HibernateException ex){
		
	    }
	    return null;
	} 
	
	public Long updateObject(AbstractPersistentClass object,User user){
	    
	    try {
	    
		AuditTrail audit = new AuditTrail();
	    
		audit.setAction("edit");
		audit.setModule(object.getClass().getName());
		audit.setUser(user);
	    
		getCurrentSession().update(object);	    
		
		audit.setNewValue(object.getId());
		getCurrentSession().save(audit);	    
	    	return object.getId();
	    	
	    } catch (HibernateException ex){
		
	    }
	    
	    return null;
	    
	    
	}
	
	
	
}