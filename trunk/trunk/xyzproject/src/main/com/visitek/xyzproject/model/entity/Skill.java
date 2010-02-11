package com.visitek.xyzproject.model.entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

public class Skill extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	String description;

	String keyword;
	
	
	

	public Skill() {
		super();
		
	}



	public Skill(String name, String description, String keyword) {
		super();
		this.name = name;
		this.description = description;
		this.keyword = keyword;
	}



	public String getDescription() {
		return description;
	}

	

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public void setName(String name) {
		this.name = name;
	}



	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
