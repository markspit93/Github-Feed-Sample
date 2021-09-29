package com.github.feed.sample.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Actor(

        @SerializedName("login")
        val username: String,

        @SerializedName("avatar_url")
        val avatar: String

) : Parcelable {

    // region Parcelable Implementation

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Actor> = object : Parcelable.Creator<Actor> {
            override fun createFromParcel(source: Parcel): Actor = Actor(source)
            override fun newArray(size: Int): Array<Actor?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(username)
        dest.writeString(avatar)
    }

    // endregion
}

