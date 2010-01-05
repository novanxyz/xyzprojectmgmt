package id.co.visitek.jproject.model.object;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "task_name")
	String name;
    @Column(name = "task_description")
	String description;
    
	
    Task  parent;
    
    Project project;
    
    Set<Department> department;

    Set<Contact> contacts;
    

	User owner;
    
    User creator;
    
    
    @Column(name = "task_start_date")
	Date startDate;
    @Column(name = "task_end_date")
	Date endDate;
    
    @Column(name = "task_duration")
	float duration;
    @Column(name = "task_hours_worked")
	float worked;
    
    @Column(name = "task_priority")
	int priority;
    @Column(name = "task_status")
	int status;
    @Column(name = "task_percent_complete")
	int percentComplete;
    int weight;
    @Column(name = "task_access")
	int access;
    @Column(name = "task_notify")
	int notify;
    @Column(name = "task_type")
	int type ;
    
    @Column(name = "task_milestone")
	boolean milestone;
    @Column(name = "task_client_publish")
	boolean clientPublish;
    @Column(name = "task_dynamic")
	boolean dynamic;
    
    @Column(name = "task_requirement")
	String requirement;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Task getParent() {
        return parent;
    }
    public void setParent(Task parent) {
        this.parent = parent;
    }
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public Set<Department> getDepartement() {
        return department;
    }
    public void setDepartment(Set<Department> departement) {
        this.department = departement;
    }
    public Set<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public User getCreator() {
        return creator;
    }
    public void setCreator(User creator) {
        this.creator = creator;
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
    public float getDuration() {
        return duration;
    }
    public void setDuration(float duration) {
        this.duration = duration;
    }
    public float getWorked() {
        return worked;
    }
    public void setWorked(float worked) {
        this.worked = worked;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getPercentComplete() {
        return percentComplete;
    }
    public void setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
    }
    public int getAccess() {
        return access;
    }
    public void setAccess(int access) {
        this.access = access;
    }
    public int getNotify() {
        return notify;
    }
    public void setNotify(int notify) {
        this.notify = notify;
    }
    public String getRequirement() {
        return requirement;
    }
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public boolean isClientPublish() {
        return clientPublish;
    }
    public void setClientPublish(boolean clientPublish) {
        this.clientPublish = clientPublish;
    }
    public boolean isDynamic() {
        return dynamic;
    }
    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public Set<Department> getDepartment() {
        return department;
    }
    
    
    
    

}
