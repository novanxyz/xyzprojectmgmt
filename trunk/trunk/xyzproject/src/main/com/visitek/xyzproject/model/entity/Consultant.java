package com.visitek.xyzproject.model.entity;

import java.util.Set;

import javax.persistence.Entity;


@Entity
public class Consultant extends Employee implements	IResource {
	private static final long serialVersionUID = 1L;
	String skillType;
	int skillLevel;
	float load;
	float cost;
	
	Set<Skill> skillSet;
	
	
	
	public float getLoad() {
		return load;
	}


	public void setLoad(float load) {
		this.load = load;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}


	public String getSkillType() {
		return skillType;
	}


	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}


	public int getSkillLevel() {
		return skillLevel;
	}


	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}


	public String getType() {		
		return this.getClassName();
	}


	public Set<Skill> getSkillSet() {
		Skill s = new Skill();
		
		s.setName( skillType );
		s.setLevel(skillLevel);
		
		return skillSet;
	}


	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}
	

}
