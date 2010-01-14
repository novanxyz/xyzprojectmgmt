package com.visitek.jproject.model.business;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.visitek.jproject.model.AbstractPersistentClass;
import com.visitek.jproject.model.entity.Contact;

@Entity
@Table(name = "users")
public class User extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;
    
       
    @Column(name = "user_username")
	String username;
    @Column(name = "user_password")
	String password;
    @Column(name = "user_realname")
	String realname;    
    @Column(name = "user_email")
	String email;
    
    boolean isActive = true;
    Role role ;
        
    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	@OneToOne(fetch = LAZY)
    Contact contact;

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
	if (realname == "" || realname == null){
	    realname = getContact().getName();
	}
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
  
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    
    @Override
    public String toString() {
	return "User " + username + " ";
    }

	public Role getRole() {
	
		return null;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
    
    
}
