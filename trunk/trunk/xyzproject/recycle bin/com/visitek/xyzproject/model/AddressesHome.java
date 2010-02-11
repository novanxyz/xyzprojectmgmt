package com.visitek.xyzproject.dao;
// Generated 29 Jan 10 10:23:51 by Hibernate Tools 3.2.5.Beta


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Addresses.
 * @see com.visitek.xyzproject.model.Addresses
 * @author Hibernate Tools
 */
public class AddressesHome {

    private static final Log log = LogFactory.getLog(AddressesHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(Addresses transientInstance) {
        log.debug("persisting Addresses instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Addresses instance) {
        log.debug("attaching dirty Addresses instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Addresses instance) {
        log.debug("attaching clean Addresses instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Addresses persistentInstance) {
        log.debug("deleting Addresses instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Addresses merge(Addresses detachedInstance) {
        log.debug("merging Addresses instance");
        try {
            Addresses result = (Addresses) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Addresses findById( java.lang.Long id) {
        log.debug("getting Addresses instance with id: " + id);
        try {
            Addresses instance = (Addresses) sessionFactory.getCurrentSession()
                    .get("com.visitek.xyzproject.model.Addresses", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List<Addresses> findByExample(Addresses instance) {
        log.debug("finding Addresses instance by example");
        try {
            List<Addresses> results = (List<Addresses>) sessionFactory.getCurrentSession()
                    .createCriteria("com.visitek.xyzproject.model.Addresses")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    
    public List<Addresses> listALL(){
    		log.debug("finding Addresses instance by example");
        try {
            List<Addresses> results = (List<Addresses>) sessionFactory.getCurrentSession()
                    .createQuery("from com.visitek.xyzproject.model.Addresses")                   
            				.list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }	
    }
}

