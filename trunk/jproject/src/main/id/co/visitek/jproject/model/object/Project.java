package id.co.visitek.jproject.model.object;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "projects")
public class Project extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "project_status")
	int status;
    @Column(name = "project_percent_complete")
	int percentComplete;
    @Column(name = "project_priority")
	int priority;
    @Column(name = "project_type")
	int type;
    
    @Column(name = "project_name")
	String name;
    @Column(name = "project_short_name")
	String shortName;
    @Column(name = "project_code")
	String code;
    @Column(name = "project_url")
	String url;
    @Column(name= "project_description")
    String descripion;
    
    @Column(name= "project_color_identifier")
    String colorId;
            
    
    User owner;
    
    Company company;
    
    Company internalCompany;
    
    
	Department department;    
    
    public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	Set<Contact> contacts;
    
	
    Set<Task>	tasks;
    
    @OneToOne    
    User creator;
    
    @Column(name = "project_start_date")
    Date startDate;
    @Column(name = "project_end_date")
    Date endDate;
    

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getPercentComplete() {	
	if ( percentComplete == 0 ){
	 Task protasks ;
	  while (tasks.iterator().hasNext()){
	      protasks = tasks.iterator().next();
	      percentComplete += protasks.getPercentComplete()/ (protasks.getWeight() * 100);
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
        return contacts;
    }
    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
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
    
    
    
    
    
    
    
    
    
    
    
    

}
