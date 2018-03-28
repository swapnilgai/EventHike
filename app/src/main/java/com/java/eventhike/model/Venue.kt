package com.java.eventhike.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Venue(

		@field:SerializedName("emails")
	val emails: List<String?>? = null,

		@field:SerializedName("profilePicture")
	val profilePicture: String? = null,

		@field:SerializedName("coverPicture")
	val coverPicture: String? = null,

		@field:SerializedName("name")
	val name: String? = null,

		@field:SerializedName("about")
	val about: String? = null,

		@field:SerializedName("categoryList")
	val categoryList: List<String?>? = null,

		@field:SerializedName("location")
	val location: Location? = null,

		@field:SerializedName("id")
	val id: String? = null,

		@field:SerializedName("category")
	val category: String? = null
): Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.createStringArrayList(),
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			parcel.createStringArrayList(),
			parcel.readParcelable(Location::class.java.classLoader),
			parcel.readString(),
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeStringList(emails)
		parcel.writeString(profilePicture)
		parcel.writeString(coverPicture)
		parcel.writeString(name)
		parcel.writeString(about)
		parcel.writeStringList(categoryList)
		parcel.writeParcelable(location, flags)
		parcel.writeString(id)
		parcel.writeString(category)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Venue> {
		override fun createFromParcel(parcel: Parcel): Venue {
			return Venue(parcel)
		}

		override fun newArray(size: Int): Array<Venue?> {
			return arrayOfNulls(size)
		}
	}
}