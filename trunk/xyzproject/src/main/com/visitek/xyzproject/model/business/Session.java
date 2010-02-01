package com.visitek.xyzproject.model.business;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class Session extends AbstractPersistentClass {
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

	// seam-gen attribute getters/setters with annotations (you probably should
	// edit)

	public String getIp() {
		return ip;
	}

	public Date getLogIn() {
		return logIn;
	}

	public Date getLogOut() {
		return logOut;
	}

	public String getName() {
		return name;
	}

	public User getUser() {
		return user;
	}

	@Id
	@GeneratedValue
	@Version
	public Integer getVersion() {
		return version;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setLogIn(Date logIn) {
		this.logIn = logIn;
	}

	public void setLogOut(Date logOut) {
		this.logOut = logOut;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
