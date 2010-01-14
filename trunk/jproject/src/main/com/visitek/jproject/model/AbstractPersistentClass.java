/**
 * @author R. Ardhian (rardhian@gmail.com)
 * December 2007
 */

package com.visitek.jproject.model;



import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.Id;

import com.visitek.jproject.util.KeyValueUtil;



public class AbstractPersistentClass implements Serializable {
	public static final long serialVersionUID = 1L;
	
	Long id;

	
	@Id
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
	
	public String toString(){
		
		String s = getName();
		for (int i= 0 ;i < getClass().getFields().length;i++){
			Field f =getClass().getFields()[i];
			if (f.getClass().isPrimitive()){
				// may be it's need to be converted to key-values;				
				try {
					s += " " + f.getName() + " " + KeyValueUtil.getKeyValue(getName(),f.getName(),f.getInt(f));
				} catch (IllegalArgumentException e) {
										
				} catch (IllegalAccessException e) {
									
				}
				
			}else{
				s += " " + f.getName() + ":" + f.toString();
			}
		}
		
		
		return s;
		
	}
}
