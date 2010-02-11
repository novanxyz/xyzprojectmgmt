package com.visitek.xyzproject.model.entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class ConsultantSkill extends AbstractPersistentClass {
	
	Skill skill;
	int level;
	String experiences;
	

		
	public ConsultantSkill() {
		super();
	
	}


	public ConsultantSkill(Skill skill, int level, String experiences) {
		super();
		this.skill = skill;
		this.level = level;
		this.experiences = experiences;
	}


	public ConsultantSkill(Skill skill) {
		this.skill = skill;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public String getExperiences() {
		return experiences;
	}


	public void setExperiences(String experiences) {
		this.experiences = experiences;
	}


	public Skill getSkill() {
		return skill;
	}


	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
	
	
	
}
