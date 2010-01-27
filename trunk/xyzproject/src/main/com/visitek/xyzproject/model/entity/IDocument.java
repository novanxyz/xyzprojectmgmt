package com.visitek.xyzproject.model.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.visitek.xyzproject.model.IPersistentObject;

@Entity
public interface IDocument extends IPersistentObject {

	public Date getDate();

	public String getDocumentNumber();

	public String getName();

	public String getType();

}
