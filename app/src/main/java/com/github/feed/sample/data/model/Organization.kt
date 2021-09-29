package com.github.feed.sample.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Organization(

        @SerializedName("id")
        val id: Int,

        @SerializedName("login")
        val login: String,

        @SerializedName("url")
        val url: String,

        @SerializedName("avatar_url")
        val avatar: String

) : Parcelable {

    // region Parcelable Implementation

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Organization> = object : Parcelable.Creator<Organization> {
            override fun createFromParcel(source: Parcel): Organization = Organization(source)
            override fun newArray(size: Int): Array<Organization?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(login)
        dest.writeString(url)
        dest.writeString(avatar)
    }

    // endregion
}
