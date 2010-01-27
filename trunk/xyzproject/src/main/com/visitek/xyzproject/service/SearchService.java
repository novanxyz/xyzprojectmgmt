package com.visitek.xyzproject.service;

import java.util.List;
import java.util.Set;

import com.visitek.xyzproject.app.Constants;
import com.visitek.xyzproject.model.AbstractPersistentClass;

public class SearchService {

	public static Set<AbstractPersistentClass> getAllObjectByAddressId(List ids) {

		return null;
	}

	public static Set<AbstractPersistentClass> searchByAddress(String addresskey) {

		return null;
	}

	public static Set<AbstractPersistentClass> searchByLocation(
			float longitude, float latitude, float radiuskm) {

		float radiusdeg = radiuskm / 111f;

		Constants.em.createNamedQuery("addrByLocation").setParameter("lo",
				longitude).setParameter("lat", latitude).setParameter("radius",
				radiusdeg).getResultList();
		return null;
	}

	public static Set<AbstractPersistentClass> searchByName(String namekey) {

		return null;
	}

}
