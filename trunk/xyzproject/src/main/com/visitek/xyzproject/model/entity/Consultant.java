package com.visitek.xyzproject.model.entity;

import java.util.Set;

import com.visitek.xyzproject.model.business.User;


public class Consultant extends Employee implements IResource {
	private static final long serialVersionUID = 1L;
	String skillType;
	int skillLevel;
	float load;
	float cost;

	User user;

	Set<Skill> skillSet;

	public Consultant() {
		super();
	}

	public float getCost() {
		return cost;
	}

	public float getLoad() {
		return load;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public Set<Skill> getSkillSet() {
		Skill s = new Skill();

		s.setName(skillType);
		s.setLevel(skillLevel);

		return skillSet;
	}

	public String getSkillType() {
		return skillType;
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

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
