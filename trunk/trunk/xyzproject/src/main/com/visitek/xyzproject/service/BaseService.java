package com.visitek.xyzproject.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.visitek.xyzproject.app.Constants;

public abstract class BaseService<T> {
	static EntityManager em;

	protected static EntityManager getEntityManager() {

		if (em == null)
			try {
				EntityManagerFactory emf = Persistence
						.createEntityManagerFactory(Constants.jpaUnitName);
				em = emf.createEntityManager();
			} catch (Exception e) {
				throw new IllegalStateException(
						"EntityManager has not been set on DAO before usage");
			}

		return em;
	}

	private Class<T> entityType;

	public BaseService() {
		this.entityType = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T find(Long id) {
		T entity = getEntityManager().find(getEntityType(), id);
		return entity;

	}

	public T findByName(String name, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) getEntityManager().createNamedQuery(
					"find" + getEntityType() + "byName").setParameter("name",
					name).getSingleResult();
			em.lock(entity, LockModeType.WRITE);
		} else
			entity = (T) getEntityManager().createNamedQuery(
					"find" + getEntityType() + "byName").setParameter("name",
					name).getSingleResult();
		return entity;
	}

	public void flush() {
		getEntityManager().flush();
	}

	private Class<T> getEntityType() {
		return entityType;

	}

	public List<T> listAll() {
		return getEntityManager().createQuery(
				"from " + getEntityType().getName()).getResultList();
	}

	public T load(Long id) {
		T entity = getEntityManager().find(getEntityType(), id);
		return entity;

	}

	public T load(Long id, boolean lock) {
		if (lock)
			return lock(id);
		else
			return load(id);
	}

	public T lock(Long id) {
		T entity = getEntityManager().find(getEntityType(), id);
		em.lock(entity, LockModeType.WRITE);
		return entity;
	}

	public void lock(T e) {
		getEntityManager().lock(e, LockModeType.WRITE);
	}

	public void merge(T o) {
		getEntityManager().merge(o);
	}

	public void persist(T o) {
		getEntityManager().persist(o);
	}

	public void remove(T o) {
		getEntityManager().refresh(o);
	}

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	public void setEntityManager(EntityManager em) {
		BaseService.em = em;
	}

}
