package com.visitek.xyzproject.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.LockModeType;

import com.visitek.xyzproject.app.Constants;

public abstract class Service<T> {
	EntityManager em;
	private Class<T> entityType;
	
	
	public Service() {
		this.entityType = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public T find(Long id) {
		return getEntityManager().find(getEntityType(), id);
		
	}
	
	public T findById(Long id, boolean lock) {
        T entity;
        if (lock) {
            entity = getEntityManager().find(getEntityType(), id);
            em.lock(entity, LockModeType.WRITE);
        } else {
            entity = getEntityManager().find(getEntityType(), id);
        }
        return entity;
    }
	
	public T findByName(String name, boolean lock) {
        T entity;
        if (lock) {
            entity = (T) getEntityManager().createNamedQuery("findbyName").setParameter("name", name).getSingleResult();
            em.lock(entity, LockModeType.WRITE);
        } else {
        	entity = (T) getEntityManager().createNamedQuery("find"+getEntityType()+"byName").setParameter("name", name).getSingleResult();
        }
        return entity;
    }
	
	
	public List<T> listAll() {
        return getEntityManager().createQuery("from " + getEntityType().getName() ).getResultList();
    }


	private Class<T> getEntityType() {		
		return entityType;
	}

	private EntityManager getEntityManager() {
		
		if (em == null) {
			try {				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.jpaUnitName);
				em = emf.createEntityManager();				
			}catch (Exception e) {
				throw new IllegalStateException("EntityManager has not been set on DAO before usage");
			}
		}
		
		return em;
	}

	
	
	
}
