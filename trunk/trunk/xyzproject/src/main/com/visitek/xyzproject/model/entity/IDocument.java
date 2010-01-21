package com.visitek.xyzproject.model.entity;


import java.util.Date;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.IPersistentObject;

@Entity
public interface IDocument extends IPersistentObject  {
	
	public String getName();	
	public String getDocumentNumber();	
	public Date getDate();	
	public String getType();

}
