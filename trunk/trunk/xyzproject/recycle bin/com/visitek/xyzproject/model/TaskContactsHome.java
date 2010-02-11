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
 * Home object for domain model class TaskContacts.
 * @see com.visitek.xyzproject.model.TaskContacts
 * @author Hibernate Tools
 */
public class TaskContactsHome {

    private static final Log log = LogFactory.getLog(TaskContactsHome.class);

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
    
    public void persist(TaskContacts transientInstance) {
        log.debug("persisting TaskContacts instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(TaskContacts instance) {
        log.debug("attaching dirty TaskContacts instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TaskContacts instance) {
        log.debug("attaching clean TaskContacts instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(TaskContacts persistentInstance) {
        log.debug("deleting TaskContacts instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TaskContacts merge(TaskContacts detachedInstance) {
        log.debug("merging TaskContacts instance");
        try {
            TaskContacts result = (TaskContacts) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public TaskContacts findById( com.visitek.xyzproject.model.TaskContactsId id) {
        log.debug("getting TaskContacts instance with id: " + id);
        try {
            TaskContacts instance = (TaskContacts) sessionFactory.getCurrentSession()
                    .get("com.visitek.xyzproject.model.TaskContacts", id);
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
    
    public List<TaskContacts> findByExample(TaskContacts instance) {
        log.debug("finding TaskContacts instance by example");
        try {
            List<TaskContacts> results = (List<TaskContacts>) sessionFactory.getCurrentSession()
                    .createCriteria("com.visitek.xyzproject.model.TaskContacts")
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

