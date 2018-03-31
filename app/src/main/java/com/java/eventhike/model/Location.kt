package com.java.eventhike.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Location(

	@field:SerializedName("zip")
	val zip: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null
): Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			parcel.readValue(Double::class.java.classLoader) as? Double,
			parcel.readString(),
			parcel.readValue(Double::class.java.classLoader) as? Double) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(zip)
		parcel.writeString(country)
		parcel.writeString(city)
		parcel.writeString(street)
		parcel.writeValue(latitude)
		parcel.writeString(state)
		parcel.writeValue(longitude)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Location> {
		override fun createFromParcel(parcel: Parcel): Location {
			return Location(parcel)
		}

		override fun newArray(size: Int): Array<Location?> {
			return arrayOfNulls(size)
		}
	}
}