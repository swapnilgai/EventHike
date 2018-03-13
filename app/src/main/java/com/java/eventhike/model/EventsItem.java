package com.java.eventhike.model;
import com.google.gson.annotations.SerializedName;

public class EventsItem{

	@SerializedName("dateTime")
	private DateTime dateTime;

	@SerializedName("eventVenueId")
	private String eventVenueId;

	@SerializedName("eventImageUrl")
	private String eventImageUrl;

	@SerializedName("eventCategory")
	private Object eventCategory;

	@SerializedName("eventAwayDistanve")
	private String eventAwayDistanve;

	@SerializedName("eventDescription")
	private String eventDescription;

	@SerializedName("eventName")
	private String eventName;

	@SerializedName("timeFromNow")
	private String timeFromNow;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private String id;

	@SerializedName("eventType")
	private String eventType;

	@SerializedName("facebookEventId")
	private String facebookEventId;

	public void setDateTime(DateTime dateTime){
		this.dateTime = dateTime;
	}

	public DateTime getDateTime(){
		return dateTime;
	}

	public void setEventVenueId(String eventVenueId){
		this.eventVenueId = eventVenueId;
	}

	public String getEventVenueId(){
		return eventVenueId;
	}

	public void setEventImageUrl(String eventImageUrl){
		this.eventImageUrl = eventImageUrl;
	}

	public String getEventImageUrl(){
		return eventImageUrl;
	}

	public void setEventCategory(Object eventCategory){
		this.eventCategory = eventCategory;
	}

	public Object getEventCategory(){
		return eventCategory;
	}

	public void setEventAwayDistanve(String eventAwayDistanve){
		this.eventAwayDistanve = eventAwayDistanve;
	}

	public String getEventAwayDistanve(){
		return eventAwayDistanve;
	}

	public void setEventDescription(String eventDescription){
		this.eventDescription = eventDescription;
	}

	public String getEventDescription(){
		return eventDescription;
	}

	public void setEventName(String eventName){
		this.eventName = eventName;
	}

	public String getEventName(){
		return eventName;
	}

	public void setTimeFromNow(String timeFromNow){
		this.timeFromNow = timeFromNow;
	}

	public String getTimeFromNow(){
		return timeFromNow;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEventType(String eventType){
		this.eventType = eventType;
	}

	public String getEventType(){
		return eventType;
	}

	public void setFacebookEventId(String facebookEventId){
		this.facebookEventId = facebookEventId;
	}

	public String getFacebookEventId(){
		return facebookEventId;
	}
}