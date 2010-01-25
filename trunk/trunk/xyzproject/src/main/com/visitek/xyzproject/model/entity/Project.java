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

	public void addContact(Contact con) {
		getContacts().add(con);
	}

	public void addTask(Task task) {
		getTasks().add(task);
	}

	public String getCode() {
		return code;
	}

	public String getColorId() {
		return colorId;
	}

	public Company getCompany() {
		return company;
	}

	public Set<Contact> getContacts() {

		Iterator it = getTasks().iterator();
		Set<Contact> c = contacts;
		while (it.hasNext()) {
			Task t = (Task) it.next();
			c.addAll(t.getContacts());
		}
		return c;
	}

	public String getDescripion() {
		return descripion;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Company getInternalCompany() {
		return internalCompany;
	}

	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
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

	public int getPriority() {
		return priority;
	}

	public String getShortName() {
		return shortName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public int getStatus() {
		return status;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public int getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public void removeContact(Contact e) {
		getContacts().remove(e);
	}

	public void removeTask(Task task) {
		getTasks().remove(task);
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setInternalCompany(Company internalCompany) {
		this.internalCompany = internalCompany;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setPercentComplete(int percentComplete) {
		this.percentComplete = percentComplete;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
