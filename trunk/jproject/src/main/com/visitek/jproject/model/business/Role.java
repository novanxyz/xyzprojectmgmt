package com.visitek.jproject.model.business;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.visitek.jproject.model.AbstractPersistentClass;

@Entity
@Table(name = "roles")
public class Role extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

}
