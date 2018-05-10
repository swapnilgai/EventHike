package com.java.eventhike.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Stats(

	@field:SerializedName("declined")
	val declined: Int? = null,

	@field:SerializedName("noreply")
	val noreply: Int? = null,

	@field:SerializedName("maybe")
	val maybe: Int? = null,

	@field:SerializedName("attending")
	val attending: Int? = null
): Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readValue(Int::class.java.classLoader) as? Int) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(declined)
		parcel.writeValue(noreply)
		parcel.writeValue(maybe)
		parcel.writeValue(attending)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Stats> {
		override fun createFromParcel(parcel: Parcel): Stats {
			return Stats(parcel)
		}

		override fun newArray(size: Int): Array<Stats?> {
			return arrayOfNulls(size)
		}
	}
}