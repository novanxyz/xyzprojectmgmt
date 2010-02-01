package com.visitek.xyzproject.model.entity;

import java.util.Date;

public class Employee extends Contact {
	private static final long serialVersionUID = 1L;

	String NIK;
	int grade;
	Date joinDate;
	int spk_type;

	public int getGrade() {
		return grade;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public String getNIK() {
		return NIK;
	}

	public int getSpk_type() {
		return spk_type;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public void setNIK(String nIK) {
		NIK = nIK;
	}

	public void setSpk_type(int spkType) {
		spk_type = spkType;
	}

}
