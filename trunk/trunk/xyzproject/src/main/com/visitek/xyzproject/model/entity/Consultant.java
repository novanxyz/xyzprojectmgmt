package com.visitek.xyzproject.model.entity;

import java.util.Set;

import com.visitek.xyzproject.model.business.User;


public class Consultant extends Employee implements IResource {
	private static final long serialVersionUID = 1L;
	
	float load;
	float cost;
	User user;

	Set<ConsultantSkill> skillSet;

	public Consultant() {
		super();
	}
	
	public Consultant(float load, float cost, User user,
			Set<ConsultantSkill> skillSet) {
		super();
		this.load = load;
		this.cost = cost;
		this.user = user;
		this.skillSet = skillSet;
	}



	public float getCost() {
		return cost;
	}

	public float getLoad() {
		return load;
	}



	public String getType() {
		return this.getClassName();
	}

	public User getUser() {
		return user;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setLoad(float load) {
		this.load = load;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Set<ConsultantSkill> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(Set<ConsultantSkill> skillSet) {
		this.skillSet = skillSet;
	}
	
	public void addSkill(Skill skill, int level){
		ConsultantSkill cskill = new ConsultantSkill(skill);		
		cskill.level = level;
		getSkillSet().add(cskill);
		
	}

}
