package com.visitek.xyzproject.model.entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

public class Skill extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	String description;
	
	int level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
