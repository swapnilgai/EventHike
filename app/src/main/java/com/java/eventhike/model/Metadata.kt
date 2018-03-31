package com.java.eventhike.model

import com.google.gson.annotations.SerializedName

data class Metadata(

	@field:SerializedName("venuesWithEvents")
	val venuesWithEvents: Int? = null,

	@field:SerializedName("venues")
	val venues: Int? = null,

	@field:SerializedName("events")
	val events: Int? = null
)