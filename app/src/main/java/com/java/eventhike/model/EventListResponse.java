package com.java.eventhike.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventListResponse{

	@SerializedName("events")
	private List<EventsItem> events;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}
}