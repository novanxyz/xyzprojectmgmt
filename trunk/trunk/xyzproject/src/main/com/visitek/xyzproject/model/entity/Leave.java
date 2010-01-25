package com.visitek.xyzproject.model.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;

@Entity
public class Leave extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	Employee employee;
	Date startDate;
	Date endDate;
	String reason;
	boolean approved;

	public Employee getEmployee() {
		return employee;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getReason() {
		return reason;
	}

	public Date getStartDate() {
		return startDate;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
