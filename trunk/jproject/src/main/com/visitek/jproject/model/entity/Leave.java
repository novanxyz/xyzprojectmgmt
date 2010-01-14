package com.visitek.jproject.model.entity;

import java.util.Date;

import com.visitek.jproject.model.AbstractPersistentClass;

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
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
    
    
    

}
