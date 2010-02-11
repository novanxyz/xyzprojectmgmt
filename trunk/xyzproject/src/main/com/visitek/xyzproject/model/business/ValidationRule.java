package com.visitek.xyzproject.model.business;

import com.visitek.xyzproject.model.AbstractPersistentClass;


public class ValidationRule extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;
	public static int VALIDATION_RULE_TYPE_NULL = 0;
	public static int VALIDATION_RULE_TYPE_UNIQUE = 1;
	public static int VALIDATION_RULE_TYPE_RANGE = 2;
	public static int VALIDATION_RULE_TYPE_FORMAT = 3;

	String name;
	String testExpression;
	String trueFormula;
	String falseFormula;
	String exceptionMessage;

	int type;
	int group;
	int priority;
	
	

	public ValidationRule() {
		super();	
	}
	

	public ValidationRule(String name) {
		super();
		this.name = name;
	}


	public ValidationRule(String name, String testExpression,
			String trueFormula, String falseFormula, String exceptionMessage,
			int type, int group, int priority) {
		super();
	
		this.name = name;
		this.testExpression = testExpression;
		this.trueFormula = trueFormula;
		this.falseFormula = falseFormula;
		this.exceptionMessage = exceptionMessage;
		this.type = type;
		this.group = group;
		this.priority = priority;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public String getFalseFormula() {
		return falseFormula;
	}

	public int getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	public String getTestExpression() {
		return testExpression;
	}

	public String getTrueFormula() {
		return trueFormula;
	}

	public int getType() {
		return type;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public void setFalseFormula(String falseFormula) {
		this.falseFormula = falseFormula;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setTestExpression(String testExpression) {
		this.testExpression = testExpression;
	}

	public void setTrueFormula(String trueFormula) {
		this.trueFormula = trueFormula;
	}

	public void setType(int type) {
		this.type = type;
	}

}
