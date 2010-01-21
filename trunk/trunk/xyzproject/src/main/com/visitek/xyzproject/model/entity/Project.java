package com.visitek.xyzproject.model.entity;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.AbstractPersistentClass;
import com.visitek.xyzproject.model.business.User;

@Entity
public class Project extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	int status;
	int percentComplete;
	int priority;
	int type;
	String name;

	String shortName;

	String code;

	String url;

	String descripion;

	String colorId;

	User owner;
	Company company;
	Company internalCompany;

	Set<Contact> contacts;
	Set<Task> tasks;

	Date startDate;
	
	Date endDate;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPercentComplete() {
		if (percentComplete == 0) {
			Task protasks;
			while (tasks.iterator().hasNext()) {
				protasks = tasks.iterator().next();
				percentComplete += protasks.getPercentComplete()
						/ (protasks.getWeight() * 100);
			}
		}
		return percentComplete;
	}

	public void setPercentComplete(int percentComplete) {
		this.percentComplete = percentComplete;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Company getInternalCompany() {
		return internalCompany;
	}

	public void setInternalCompany(Company internalCompany) {
		this.internalCompany = internalCompany;
	}

	public Set<Contact> getContacts() {
		
		Iterator it = getTasks().iterator();
		Set<Contact> c = contacts;
		while (it.hasNext()){
			Task t = (Task)it.next();
			c.addAll(t.getContacts());
		}				
		return c;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
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

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	public void addTask(Task task){
		getTasks().add(task);
	}
	public void removeTask(Task task){
		getTasks().remove(task);		
	}
	
	public void addContact(Contact con){
		getContacts().add(con);
	}
	
	public void removeContact(Contact e){
		getContacts().remove(e);
	}

}
