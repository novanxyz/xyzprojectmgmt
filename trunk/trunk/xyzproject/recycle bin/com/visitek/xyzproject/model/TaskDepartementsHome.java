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
 * Home object for domain model class TaskDepartements.
 * @see com.visitek.xyzproject.model.TaskDepartements
 * @author Hibernate Tools
 */
public class TaskDepartementsHome {

    private static final Log log = LogFactory.getLog(TaskDepartementsHome.class);

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
    
    public void persist(TaskDepartements transientInstance) {
        log.debug("persisting TaskDepartements instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(TaskDepartements instance) {
        log.debug("attaching dirty TaskDepartements instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TaskDepartements instance) {
        log.debug("attaching clean TaskDepartements instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(TaskDepartements persistentInstance) {
        log.debug("deleting TaskDepartements instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TaskDepartements merge(TaskDepartements detachedInstance) {
        log.debug("merging TaskDepartements instance");
        try {
            TaskDepartements result = (TaskDepartements) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public TaskDepartements findById( com.visitek.xyzproject.model.TaskDepartementsId id) {
        log.debug("getting TaskDepartements instance with id: " + id);
        try {
            TaskDepartements instance = (TaskDepartements) sessionFactory.getCurrentSession()
                    .get("com.visitek.xyzproject.model.TaskDepartements", id);
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
    
    public List<TaskDepartements> findByExample(TaskDepartements instance) {
        log.debug("finding TaskDepartements instance by example");
        try {
            List<TaskDepartements> results = (List<TaskDepartements>) sessionFactory.getCurrentSession()
                    .createCriteria("com.visitek.xyzproject.model.TaskDepartements")
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

