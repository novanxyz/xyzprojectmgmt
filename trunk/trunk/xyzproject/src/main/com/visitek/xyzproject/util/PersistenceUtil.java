package com.visitek.xyzproject.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.visitek.xyzproject.app.Constants;


public class PersistenceUtil {
	private static PersistenceUtil me;
	private static EntityManagerFactory emf;	
	
	static {
		me = new PersistenceUtil();		
	}
	
	public PersistenceUtil() {
		emf = Persistence.createEntityManagerFactory(Constants.jpaUnitName);
	}

	public static EntityManagerFactory getEntityManagerFactory(){
	
		if (emf == null){
			emf = Persistence.createEntityManagerFactory(Constants.jpaUnitName);   
		}		
		return emf;
	}
	
	public static EntityManager getEntityManager(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();     
      return em;
	}

}
