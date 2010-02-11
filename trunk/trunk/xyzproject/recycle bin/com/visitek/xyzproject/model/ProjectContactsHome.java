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
 * Home object for domain model class ProjectContacts.
 * @see com.visitek.xyzproject.model.ProjectContacts
 * @author Hibernate Tools
 */
public class ProjectContactsHome {

    private static final Log log = LogFactory.getLog(ProjectContactsHome.class);

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
    
    public void persist(ProjectContacts transientInstance) {
        log.debug("persisting ProjectContacts instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(ProjectContacts instance) {
        log.debug("attaching dirty ProjectContacts instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProjectContacts instance) {
        log.debug("attaching clean ProjectContacts instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(ProjectContacts persistentInstance) {
        log.debug("deleting ProjectContacts instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProjectContacts merge(ProjectContacts detachedInstance) {
        log.debug("merging ProjectContacts instance");
        try {
            ProjectContacts result = (ProjectContacts) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ProjectContacts findById( com.visitek.xyzproject.model.ProjectContactsId id) {
        log.debug("getting ProjectContacts instance with id: " + id);
        try {
            ProjectContacts instance = (ProjectContacts) sessionFactory.getCurrentSession()
                    .get("com.visitek.xyzproject.model.ProjectContacts", id);
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
    
    public List<ProjectContacts> findByExample(ProjectContacts instance) {
        log.debug("finding ProjectContacts instance by example");
        try {
            List<ProjectContacts> results = (List<ProjectContacts>) sessionFactory.getCurrentSession()
                    .createCriteria("com.visitek.xyzproject.model.ProjectContacts")
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

