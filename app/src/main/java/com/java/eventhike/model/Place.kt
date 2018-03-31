package com.java.eventhike.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Place(

		@field:SerializedName("name")
	val name: String? = null,

		@field:SerializedName("location")
	val location: Location? = null,

		@field:SerializedName("id")
	val id: String? = null
): Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readParcelable(Location::class.java.classLoader),
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(name)
		parcel.writeParcelable(location, flags)
		parcel.writeString(id)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Place> {
		override fun createFromParcel(parcel: Parcel): Place {
			return Place(parcel)
		}

		override fun newArray(size: Int): Array<Place?> {
			return arrayOfNulls(size)
		}
	}
}