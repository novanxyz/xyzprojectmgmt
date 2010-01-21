package com.visitek.xyzproject.model.business;

import java.util.Set;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
public class Validation extends AbstractPersistentClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	String module;
	String property;
	
	boolean type;
	
	Set<ValidationRule> rules;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public Set<ValidationRule> getRules() {
		return rules;
	}

	public void setRules(Set<ValidationRule> rules) {
		this.rules = rules;
	}
	
	

}
