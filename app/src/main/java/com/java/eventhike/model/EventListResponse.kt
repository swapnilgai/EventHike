package com.java.eventhike.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class EventListResponse(

        @field:SerializedName("metadata")
	val metadata: Metadata? = null,

        @field:SerializedName("events")
	val events: List<EventsItem?>? = null
): Parcelable {
	constructor(parcel: Parcel) : this(
			TODO("metadata"),
			TODO("events")) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {

	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<EventListResponse> {
		override fun createFromParcel(parcel: Parcel): EventListResponse {
			return EventListResponse(parcel)
		}

		override fun newArray(size: Int): Array<EventListResponse?> {
			return arrayOfNulls(size)
		}
	}
}