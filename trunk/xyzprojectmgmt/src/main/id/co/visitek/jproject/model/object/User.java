package id.co.visitek.jproject.model.object;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AbstractPersistentClass {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "user_nik")
	String nik;
    
    @Column(name = "user_username")
	String username;
    @Column(name = "user_password")
	String password;
    @Column(name = "user_realname")
	String realname;    
    @Column(name = "user_signature")
	String signature;
        
    @OneToOne(fetch = LAZY)
    Contact contact;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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
    
    
    
}
