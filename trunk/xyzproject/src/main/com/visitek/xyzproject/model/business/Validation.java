package com.visitek.xyzproject.model.business;

import java.util.Set;

import com.visitek.xyzproject.model.AbstractPersistentClass;


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

	public void addRule(ValidationRule rule) {
		getRules().add(rule);
	}

	public String getModule() {
		return module;
	}

	public String getName() {
		return name;
	}

	public String getProperty() {
		return property;
	}

	public Set<ValidationRule> getRules() {
		return rules;
	}

	public boolean isType() {
		return type;
	}

	public void removeRule(ValidationRule rule) {
		getRules().remove(rule);
	}

	public void setModule(String module) {
		this.module = module;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void setRules(Set<ValidationRule> rules) {
		this.rules = rules;
	}

	public void setType(boolean type) {
		this.type = type;
	}

}
