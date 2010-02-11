package com.visitek.xyzproject.model.business;

import com.visitek.xyzproject.model.AbstractPersistentClass;

public class Action extends AbstractPersistentClass {
	
	public String objectId;
	public User actor;
	public String command;
	public int actionType;
	

	public Action() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Action(String objectId, User actor, String command, int actionType) {
		super();
		this.objectId = objectId;
		this.actor = actor;
		this.command = command;
		this.actionType = actionType;
	}




	public String getObjectId() {
		return objectId;
	}


	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}


	public User getActor() {
		return actor;
	}


	public void setActor(User actor) {
		this.actor = actor;
	}


	public int getActionType() {
		return actionType;
	}


	public void setActionType(int actionType) {
		this.actionType = actionType;
	}


	public String getCommand() {
		return command;
	}


	public void setCommand(String command) {
		this.command = command;
	}

}
