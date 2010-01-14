package com.visitek.jproject.model.business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.visitek.jproject.model.AbstractPersistentClass;

@Entity
@Table(name = "sessions")
public class Session extends AbstractPersistentClass{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// seam-gen attributes (you should probably edit these)    
    private Integer version;
    private String name;
    
    /**
     * 
     */
    private User user;
    private String ip;
    private Date logIn;
    private Date logOut;
    

    // add additional entity attributes

    // seam-gen attribute getters/setters with annotations (you probably should edit)

    @Id @GeneratedValue   

    @Version
    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLogIn() {
		return logIn;
	}

	public void setLogIn(Date logIn) {
		this.logIn = logIn;
	}

	public Date getLogOut() {
		return logOut;
	}

	public void setLogOut(Date logOut) {
		this.logOut = logOut;
	}

    

}
