package com.visitek.xyzproject.util.db;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import com.visitek.xyzproject.model.AbstractPersistentClass;
import com.visitek.xyzproject.model.business.AuditTrail;
import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.service.UserSessionService;

public class HibernateAuditTrailUtil implements Interceptor{
    private SessionFactory sessionFactory;
    private static final String UPDATE = "update";
    private static final String INSERT = "insert";
    private static final String DELETE = "delete";
    
    
    private Set<AuditTrail> inserts = new HashSet<AuditTrail>();
    private Set<AuditTrail> updates = new HashSet<AuditTrail>();
    private Set<AuditTrail> deletes = new HashSet<AuditTrail>();
    /**
     * @param sessionFactory
     *            The sessionFactory to set.
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void afterTransactionBegin(Transaction arg0) {	
    }

    public void afterTransactionCompletion(Transaction arg0) {
	
        inserts.clear();
        updates.clear();
        deletes.clear();
	
    }

    public void beforeTransactionCompletion(Transaction arg0) {

    }

    public int[] findDirty(Object arg0, Serializable arg1, Object[] arg2,
	    Object[] arg3, String[] arg4, Type[] arg5) {
	return null;
    }

    public Object getEntity(String arg0, Serializable arg1)
	    throws CallbackException {
	return null;
    }

    public String getEntityName(Object arg0) throws CallbackException {
	return null;
    }

    public Object instantiate(String arg0, EntityMode arg1, Serializable arg2)
	    throws CallbackException {

	return null;
    }

    public Boolean isTransient(Object arg0) {
	return null;
    }

    public void onCollectionRecreate(Object arg0, Serializable arg1)
	    throws CallbackException {	
    }

    public void onCollectionRemove(Object arg0, Serializable arg1)
	    throws CallbackException {
	
	
    }

    public void onCollectionUpdate(Object arg0, Serializable arg1)
	    throws CallbackException {
	
	
    }

    public void onDelete(Object arg0, Serializable arg1, Object[] arg2,
	    String[] arg3, Type[] arg4) throws CallbackException {

	if (arg0 instanceof AbstractPersistentClass) {
            
            try {
                                
                logChanges(arg0, null, null, null, DELETE);
                
            } catch (IllegalArgumentException e) {
                
                e.printStackTrace();
            } catch (IllegalAccessException e) {
 
                e.printStackTrace();
            } catch (InvocationTargetException e) {

                e.printStackTrace();
            }
        }
	
    }

    public boolean onFlushDirty(Object arg0, Serializable arg1, Object[] arg2,
	    Object[] arg3, String[] arg4, Type[] arg5) throws CallbackException {
	
	Session session= sessionFactory.getCurrentSession();
	if (arg0 instanceof AbstractPersistentClass) {
            
            AbstractPersistentClass obj = (AbstractPersistentClass)arg0;
            // Use the id and class to get the pre-update state from the database
            Serializable persistedObjectId = obj.getId();
            Object preUpdateState = session.get(obj.getClass(),  persistedObjectId);
            
            try {
                
                logChanges(arg0, preUpdateState, null, persistedObjectId.toString(), UPDATE);
                
            } catch (IllegalArgumentException e) {
               
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            session.close();
        }
	return false;
}

    public boolean onLoad(Object arg0, Serializable arg1, Object[] arg2,
	    String[] arg3, Type[] arg4) throws CallbackException {
	return false;
    }

    public String onPrepareStatement(String arg0) {
	// TODO Auto-generated method stub
	return null;
    }

    public boolean onSave(Object arg0, Serializable arg1, Object[] arg2,
	    String[] arg3, Type[] arg4) throws CallbackException {
	
	if (arg0 instanceof AbstractPersistentClass) {
            
            try {
                                
                logChanges(arg0, null, null, null, INSERT);
                
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
	
	
    }

    public void postFlush(Iterator arg0) throws CallbackException {


        Session session = sessionFactory.openSession();

        try {
            for (Iterator itr = inserts.iterator(); itr.hasNext();) {
                AuditTrail logRecord = (AuditTrail) itr.next();                 
                session.save(logRecord);
            }
            for (Iterator itr = updates.iterator(); itr.hasNext();) {
        	AuditTrail logRecord = (AuditTrail) itr.next();
                session.save(logRecord);
            }
            for (Iterator itr = deletes.iterator(); itr.hasNext();) {
        	AuditTrail logRecord = (AuditTrail) itr.next();
                session.save(logRecord);
            }
        } catch (HibernateException e) {
            throw new CallbackException(e);
        } finally {
            inserts.clear();
            updates.clear();
            deletes.clear();
            session.flush();
            session.close();
        }	
    }

    public void preFlush(Iterator arg0) throws CallbackException {
    }
    
    public void logChanges(Object newObject, Object existingObject, Object parentObject,
            			String persistedObjectId, String event)
    		throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
	try {
	    
	AbstractPersistentClass obj=    ((AbstractPersistentClass)newObject);
	User actor = UserSessionService.getCurrentUser("");
	String module = obj.getClassName();
	AuditTrail audit = new AuditTrail();
	audit.setUser(actor);
	audit.setModule(module);
		
            if (event.equals(INSERT)){
                audit.setAction(INSERT);            
                audit.setModuleId(obj.getId());
                audit.setNewValue(obj);        
                inserts.add(audit);
            }
            
            
            if (event.equals(DELETE)){        	
        	audit.setAction(DELETE);
        	audit.setModuleId(obj.getId());
        	audit.setOldValue(obj);
                deletes.add(audit);
            }
            
            
            if (event.equals(UPDATE)){
        	audit.setAction(UPDATE);
        	Field[] newfields = newObject.getClass().getDeclaredFields();
        	Field[] oldfields = existingObject.getClass().getDeclaredFields();
        	
        	
        	for (int i= 0;i< newfields.length ;i++){
        	    
        	    
        	    Object newObj = newfields[i];
        	    Object oldObj = oldfields[i];
        	    
        	    if (newObj.getClass().getSuperclass()!= null &&
        		!newObj.getClass().getSuperclass().getName().equals("java.lang.Object") &&
        		!newObj.equals(oldObj)){        		        	
        		logChanges(newObj,oldObj,newObject,null,UPDATE);        		
        	    }else if (oldObj.equals(null)){        		
        		audit = new AuditTrail();
        		audit.setAction(INSERT);
        		audit.setUser(actor);
        		audit.setModule(module);        		
        		audit.setModuleId(obj.getId());
        		audit.setNewValue(newObj);
        		audit.setOldValue(oldObj);        		
        		inserts.add(audit);
        	    } else if (newObj.equals(null)){        		
        		audit = new AuditTrail();
        		audit.setAction(DELETE);
        		audit.setUser(actor);
        		audit.setModule(module);        		
        		audit.setModuleId(obj.getId());
        		audit.setNewValue(newObj);
        		audit.setOldValue(oldObj);        		
        		deletes.add(audit) ;        		
        	    }else if (!newObj.equals(oldObj)){
        		audit = new AuditTrail();
        		audit.setAction(UPDATE);
        		audit.setUser(actor);
        		audit.setModule(module);        		
        		audit.setModuleId(obj.getId());
        		audit.setNewValue(newObj);
        		audit.setOldValue(oldObj);
        		updates.add(audit);
        	    }        	
        	}

            }
		
	} catch (Exception ex ){
	    
	}
	
    }
    
    

}
