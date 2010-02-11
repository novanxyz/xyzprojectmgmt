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
 * Home object for domain model class Departments.
 * @see com.visitek.xyzproject.model.Departments
 * @author Hibernate Tools
 */
public class DepartmentsHome {

    private static final Log log = LogFactory.getLog(DepartmentsHome.class);

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
    
    public void persist(Departments transientInstance) {
        log.debug("persisting Departments instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Departments instance) {
        log.debug("attaching dirty Departments instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Departments instance) {
        log.debug("attaching clean Departments instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Departments persistentInstance) {
        log.debug("deleting Departments instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Departments merge(Departments detachedInstance) {
        log.debug("merging Departments instance");
        try {
            Departments result = (Departments) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Departments findById( java.lang.Long id) {
        log.debug("getting Departments instance with id: " + id);
        try {
            Departments instance = (Departments) sessionFactory.getCurrentSession()
                    .get("com.visitek.xyzproject.model.Departments", id);
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
    
    public List<Departments> findByExample(Departments instance) {
        log.debug("finding Departments instance by example");
        try {
            List<Departments> results = (List<Departments>) sessionFactory.getCurrentSession()
                    .createCriteria("com.visitek.xyzproject.model.Departments")
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

