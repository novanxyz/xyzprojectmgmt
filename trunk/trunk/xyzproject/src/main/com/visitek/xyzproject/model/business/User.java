package com.visitek.xyzproject.model.business;

import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.visitek.xyzproject.model.AbstractPersistentClass;
import com.visitek.xyzproject.model.entity.Contact;

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
    
    boolean isActive = false;
    Set<Role> roles = new HashSet<Role>();;
        
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
    
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public Set<Role> getRoles() {
	
		return	roles;
	}
	
	public void addRole(Role role){
		getRoles().add(role);
	}
	public void removeRole(Role role){
		getRoles().remove(role);
	}

    
    
    
}
