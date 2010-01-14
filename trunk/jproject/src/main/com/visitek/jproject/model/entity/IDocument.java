package com.visitek.jproject.model.entity;


import java.util.Date;

import com.visitek.jproject.model.IPersistentObject;

public interface IDocument extends IPersistentObject  {
	
	public String getName();	
	public String getDocumentNumber();	
	public Date getDate();	
	public String getType();

}
