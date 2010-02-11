package com.visitek.xyzproject.model.entity;

import java.util.Date;
import java.util.Set;

import com.visitek.xyzproject.model.AbstractPersistentClass;
import com.visitek.xyzproject.model.business.User;


public class Task extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	String name;
	String description;

	Task parent;
	Project project;

	Set<Department> departments;
	Set<Contact> contacts;

	User owner;
	User creator;

	Date startDate;
	Date endDate;

	float duration;
	float worked;

	int priority;

	int status;

	int percentComplete;
	int weight;
	int access;

	int notify;
	int type;

	public Task(String name, String description, Task parent, Project project,
			Set<Department> departments, Set<Contact> contacts, User owner,
			User creator, Date startDate, Date endDate, float duration,
			float worked, int priority, int status, int percentComplete,
			int weight, int access, int notify, int type, boolean milestone,
			boolean clientPublish, boolean dynamic, String requirement) {
		super();
		this.name = name;
		this.description = description;
		this.parent = parent;
		this.project = project;
		this.departments = departments;
		this.contacts = contacts;
		this.owner = owner;
		this.creator = creator;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.worked = worked;
		this.priority = priority;
		this.status = status;
		this.percentComplete = percentComplete;
		this.weight = weight;
		this.access = access;
		this.notify = notify;
		this.type = type;
		this.milestone = milestone;
		this.clientPublish = clientPublish;
		this.dynamic = dynamic;
		this.requirement = requirement;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	boolean milestone;

	boolean clientPublish;

	boolean dynamic;

	String requirement;

	public int getAccess() {
		return access;
	}

	public Set<Contact> getContacts() {
		contacts.add(owner.getContact());
		contacts.add(creator.getContact());
		return contacts;
	}

	public User getCreator() {
		return creator;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public String getDescription() {
		return description;
	}

	public float getDuration() {
		return duration;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getName() {
		return name;
	}

	public int getNotify() {
		return notify;
	}

	public User getOwner() {
		return owner;
	}

	public Task getParent() {
		return parent;
	}

	public int getPercentComplete() {
		return percentComplete;
	}

	public int getPriority() {
		return priority;
	}

	public Project getProject() {
		return project;
	}

	public String getRequirement() {
		return requirement;
	}

	public Date getStartDate() {
		return startDate;
	}

	public int getStatus() {
		return status;
	}

	public int getType() {
		return type;
	}

	public int getWeight() {
		return weight;
	}

	public float getWorked() {
		return worked;
	}

	public boolean isClientPublish() {
		return clientPublish;
	}

	public boolean isDynamic() {
		return dynamic;
	}

	public boolean isMilestone() {
		return milestone;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public void setClientPublish(boolean clientPublish) {
		this.clientPublish = clientPublish;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void setDepartments(Set<Department> departement) {
		this.departments = departement;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setMilestone(boolean milestone) {
		this.milestone = milestone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotify(int notify) {
		this.notify = notify;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setParent(Task parent) {
		this.parent = parent;
	}

	public void setPercentComplete(int percentComplete) {
		this.percentComplete = percentComplete;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setWorked(float worked) {
		this.worked = worked;
	}

}
