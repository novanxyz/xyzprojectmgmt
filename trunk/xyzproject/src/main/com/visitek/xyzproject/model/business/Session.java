package com.visitek.xyzproject.model.business;

import java.util.Date;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class Session extends AbstractPersistentClass {

	private static final long serialVersionUID = 1L;
	// seam-gen attributes (you should probably edit these)

	private String name;

	/**
     * 
     */
	private User user;

	private String remoteAddr;
	private Date logIn;
	private Date logOut;




	public Session() {		super();}

	public Session(String name, User user, String remoteAddr, Date logIn,
			Date logOut) {
		super();
		this.name = name;
		this.user = user;
		this.remoteAddr = remoteAddr;
		this.logIn = logIn;
		this.logOut = logOut;
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

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

}
