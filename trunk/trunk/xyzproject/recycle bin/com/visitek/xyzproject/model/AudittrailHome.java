package com.visitek.xyzproject.model;
// Generated 29 Jan 10 10:23:51 by Hibernate Tools 3.2.5.Beta


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Audittrail.
 * @see com.visitek.xyzproject.model.Audittrail
 * @author Hibernate Tools
 */
public class AudittrailHome {

    private static final Log log = LogFactory.getLog(AudittrailHome.class);

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
    
    public void persist(Audittrail transientInstance) {
        log.debug("persisting Audittrail instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Audittrail instance) {
        log.debug("attaching dirty Audittrail instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Audittrail instance) {
        log.debug("attaching clean Audittrail instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Audittrail persistentInstance) {
        log.debug("deleting Audittrail instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Audittrail merge(Audittrail detachedInstance) {
        log.debug("merging Audittrail instance");
        try {
            Audittrail result = (Audittrail) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Audittrail findById( java.lang.Long id) {
        log.debug("getting Audittrail instance with id: " + id);
        try {
            Audittrail instance = (Audittrail) sessionFactory.getCurrentSession()
                    .get("com.visitek.xyzproject.model.Audittrail", id);
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
    
    public List<Audittrail> findByExample(Audittrail instance) {
        log.debug("finding Audittrail instance by example");
        try {
            List<Audittrail> results = (List<Audittrail>) sessionFactory.getCurrentSession()
                    .createCriteria("com.visitek.xyzproject.model.Audittrail")
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
}

