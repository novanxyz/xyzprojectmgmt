/**
 * @author R. Ardhian (rardhian@gmail.com)
 * December 2007
 */

package id.co.visitek.jproject.model.object;

import java.io.Serializable;



public class AbstractPersistentClass implements Serializable {
	public static final long serialVersionUID = 1L;
	
	Long id;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || !(o instanceof IPersistentObject)) {
			return false;
		}

		// if the id is missing, return false
		if(id == null) return false;
		
		IPersistentObject other = (IPersistentObject) o;
		
		// equivalence by id
		return id.equals(other.getId());
	}
	
	public String getName(){
	    String className = this.getClass().getName();

            // Just get the class name without the package structure 
            String[] tokens = className.split("\\.");
            int lastToken = tokens.length - 1;
            className = tokens[lastToken];
            return className;
	}
	
	public int hashCode() {
		if(id != null) {
			return id.hashCode();
		}
		else {
			return super.hashCode();
		}
	}
}
