package com.visitek.jproject.model.business;

import javax.persistence.Entity;

import com.visitek.jproject.model.AbstractPersistentClass;

@Entity
public class ValidationRule extends AbstractPersistentClass {
	 public static int VALIDATION_RULE_TYPE_NULL = 0;
	 public static int VALIDATION_RULE_TYPE_UNIQUE = 1;
	 public static int VALIDATION_RULE_TYPE_RANGE = 2;
	 public static int VALIDATION_RULE_TYPE_FORMAT = 3;
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int validation_id;
	
	String name;
	String testExpression;
	String trueFormula;
	String falseFormula;
	String exceptionMessage;
	
	int type;
	int group;
	int priority;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTestExpression() {
		return testExpression;
	}
	public void setTestExpression(String testExpression) {
		this.testExpression = testExpression;
	}
	public String getTrueFormula() {
		return trueFormula;
	}
	public void setTrueFormula(String trueFormula) {
		this.trueFormula = trueFormula;
	}
	public String getFalseFormula() {
		return falseFormula;
	}
	public void setFalseFormula(String falseFormula) {
		this.falseFormula = falseFormula;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
}
