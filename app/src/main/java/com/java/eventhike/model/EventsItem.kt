package com.java.eventhike.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class EventsItem(

		@field:SerializedName("updatedTime")
	val updatedTime: String? = null,

		@field:SerializedName("distances")
	val distances: Distances? = null,

		@field:SerializedName("venue")
	val venue: Venue? = null,

		@field:SerializedName("coverPicture")
	val coverPicture: String? = null,

		@field:SerializedName("isCancelled")
	val isCancelled: Boolean? = null,

		@field:SerializedName("distance")
	val distance: Int? = null,

		@field:SerializedName("timezone")
	val timezone: String? = null,

		@field:SerializedName("description")
	val description: String? = null,

		@field:SerializedName("type")
	val type: String? = null,

		@field:SerializedName("profilePicture")
	val profilePicture: String? = null,

		@field:SerializedName("stats")
	val stats: Stats? = null,

		@field:SerializedName("name")
	val name: String? = null,

		@field:SerializedName("startTime")
	val startTime: String? = null,

		@field:SerializedName("timeFromNow")
	val timeFromNow: Int? = null,

		@field:SerializedName("id")
	val id: String? = null,

		@field:SerializedName("endTime")
	val endTime: Any? = null,

		@field:SerializedName("place")
	val place: Place? = null,

		@field:SerializedName("category")
	val category: String? = null
): Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readParcelable(Distances::class.java.classLoader),
			TODO("venue"),
			parcel.readString(),
			parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			TODO("stats"),
			parcel.readString(),
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString(),
			TODO("endTime"),
			TODO("place"),
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(updatedTime)
		parcel.writeParcelable(distances, flags)
		parcel.writeString(coverPicture)
		parcel.writeValue(isCancelled)
		parcel.writeValue(distance)
		parcel.writeString(timezone)
		parcel.writeString(description)
		parcel.writeString(type)
		parcel.writeString(profilePicture)
		parcel.writeString(name)
		parcel.writeString(startTime)
		parcel.writeValue(timeFromNow)
		parcel.writeString(id)
		parcel.writeString(category)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<EventsItem> {
		override fun createFromParcel(parcel: Parcel): EventsItem {
			return EventsItem(parcel)
		}

		override fun newArray(size: Int): Array<EventsItem?> {
			return arrayOfNulls(size)
		}
	}


}