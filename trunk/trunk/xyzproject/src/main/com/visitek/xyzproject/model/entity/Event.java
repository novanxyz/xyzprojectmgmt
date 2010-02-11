package com.visitek.xyzproject.model.entity;

import java.util.Set;

import com.visitek.xyzproject.model.AbstractPersistentClass;

public class Event extends AbstractPersistentClass {
	private static final long serialVersionUID = 1L;

	Contact from;
	String message;
	Address venue;
	Set<Contact> participants;
	int eventType;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Contact from, String message, Address venue,
			Set<Contact> participants, int eventType) {
		super();
		this.from = from;
		this.message = message;
		this.venue = venue;
		this.participants = participants;
		this.eventType = eventType;
	}

	public void addParticipant(Contact contact) {
		getParticipants().add(contact);
	}

	public int getEventType() {
		return eventType;
	}

	public String getMessage() {
		return message;
	}


	public Set<Contact> getParticipants() {
		return participants;
	}

	public Address getVenue() {
		return venue;
	}

	public void removeParticipant(Contact contact) {
		getParticipants().remove(contact);
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public void setParticipants(Set<Contact> participants) {
		this.participants = participants;
	}

	public void setVenue(Address venue) {
		this.venue = venue;
	}

	public Contact getFrom() {
		return from;
	}

	public void setFrom(Contact from) {
		this.from = from;
	}

}
