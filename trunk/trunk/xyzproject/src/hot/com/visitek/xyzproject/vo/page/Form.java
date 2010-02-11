package com.visitek.xyzproject.vo.page;

import java.lang.reflect.Field;
import java.util.Date;

import net.sf.click.control.TextField;
import net.sf.click.extras.control.DateField;

import com.visitek.xyzproject.model.AbstractPersistentClass;

public class Form extends net.sf.click.control.Form {
	
	private Class clazz;

	public Form() {
		super();
		
	}

	public Form(Class clazz) {
		super(clazz.getName());		
		setClass(clazz);
	}
	
	public Form(Object Obj){
		super(Obj.getClass().getName());
		setClass(Obj.getClass());
		copyFrom(Obj);		
	}
	
	public void setClass(Class clazz){
		
		Field[] fields = clazz.getFields();
						
		for(int i = 0; i < fields.length; i++){
			Field f = fields[i];
			if (f.getType().isPrimitive()){
				TextField tf = new TextField(f.getName());
				add(tf);
			}else if (f.getType().isInstance(AbstractPersistentClass.class)){
				
			}else if (f.getType().equals(Date.class)){
				DateField df = new DateField(f.getName());
				add(df);
			}
		}						
	}
	

	
	
}
