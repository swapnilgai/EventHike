package com.java.eventhike.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Distances(

	@field:SerializedName("venue")
	val venue: Int? = null,

	@field:SerializedName("event")
	val event: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readValue(Int::class.java.classLoader) as? Int) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(venue)
		parcel.writeValue(event)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Distances> {
		override fun createFromParcel(parcel: Parcel): Distances {
			return Distances(parcel)
		}

		override fun newArray(size: Int): Array<Distances?> {
			return arrayOfNulls(size)
		}
	}
}