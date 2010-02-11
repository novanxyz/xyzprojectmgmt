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
 * Home object for domain model class UserRoles.
 * @see com.visitek.xyzproject.model.UserRoles
 * @author Hibernate Tools
 */
public class UserRolesHome {

    private static final Log log = LogFactory.getLog(UserRolesHome.class);

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
    
    public void persist(UserRoles transientInstance) {
        log.debug("persisting UserRoles instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(UserRoles instance) {
        log.debug("attaching dirty UserRoles instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserRoles instance) {
        log.debug("attaching clean UserRoles instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(UserRoles persistentInstance) {
        log.debug("deleting UserRoles instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserRoles merge(UserRoles detachedInstance) {
        log.debug("merging UserRoles instance");
        try {
            UserRoles result = (UserRoles) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public UserRoles findById( com.visitek.xyzproject.model.UserRolesId id) {
        log.debug("getting UserRoles instance with id: " + id);
        try {
            UserRoles instance = (UserRoles) sessionFactory.getCurrentSession()
                    .get("com.visitek.xyzproject.model.UserRoles", id);
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
    
    public List<UserRoles> findByExample(UserRoles instance) {
        log.debug("finding UserRoles instance by example");
        try {
            List<UserRoles> results = (List<UserRoles>) sessionFactory.getCurrentSession()
                    .createCriteria("com.visitek.xyzproject.model.UserRoles")
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

