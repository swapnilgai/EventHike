package com.java.eventhike.model;

import com.google.gson.annotations.SerializedName;

public class Location {

	@SerializedName("venueName")
	private String venueName;

	@SerializedName("venueId")
	private String venueId;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("name")
	private String name;

	@SerializedName("venueDetail")
	private String venueDetail;

	@SerializedName("venueImageUrl")
	private String venueImageUrl;

	@SerializedName("longitude")
	private double longitude;

	public void setVenueName(String venueName){
		this.venueName = venueName;
	}

	public String getVenueName(){
		return venueName;
	}

	public void setVenueId(String venueId){
		this.venueId = venueId;
	}

	public String getVenueId(){
		return venueId;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setVenueDetail(String venueDetail){
		this.venueDetail = venueDetail;
	}

	public String getVenueDetail(){
		return venueDetail;
	}

	public void setVenueImageUrl(String venueImageUrl){
		this.venueImageUrl = venueImageUrl;
	}

	public String getVenueImageUrl(){
		return venueImageUrl;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}
}