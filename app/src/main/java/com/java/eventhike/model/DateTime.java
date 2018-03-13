package com.java.eventhike.model;

import com.google.gson.annotations.SerializedName;

public class DateTime{

	@SerializedName("dateTimeFrom")
	private String dateTimeFrom;

	@SerializedName("timeZone")
	private Object timeZone;

	@SerializedName("dateTimeTo")
	private String dateTimeTo;

	public void setDateTimeFrom(String dateTimeFrom){
		this.dateTimeFrom = dateTimeFrom;
	}

	public String getDateTimeFrom(){
		return dateTimeFrom;
	}

	public void setTimeZone(Object timeZone){
		this.timeZone = timeZone;
	}

	public Object getTimeZone(){
		return timeZone;
	}

	public void setDateTimeTo(String dateTimeTo){
		this.dateTimeTo = dateTimeTo;
	}

	public String getDateTimeTo(){
		return dateTimeTo;
	}
}