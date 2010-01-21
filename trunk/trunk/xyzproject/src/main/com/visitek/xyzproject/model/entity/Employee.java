package com.visitek.xyzproject.model.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Employee extends Contact {
	private static final long serialVersionUID = 1L;
	
	String NIK;	
	int grade;
	Date joinDate;
	int spk_type;
	
	
	public String getNIK() {
		return NIK;
	}
	public void setNIK(String nIK) {
		NIK = nIK;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getSpk_type() {
		return spk_type;
	}
	public void setSpk_type(int spkType) {
		spk_type = spkType;
	}
	
	
	

}
