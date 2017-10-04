package com.github.feed.sample.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Event(

        @SerializedName("id")
        val id: String,

        @SerializedName("type")
        val type: String,

        @SerializedName("created_at")
        val creationDate: String,

        @SerializedName("public")
        val public: Boolean,

        @SerializedName("actor")
        val actor: Actor,

        @SerializedName("repo")
        val repository: Repository,

        @SerializedName("org")
        val organization: Organization?

) : Parcelable {

    // region Parcelable Implementation

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Event> = object : Parcelable.Creator<Event> {
            override fun createFromParcel(source: Parcel): Event = Event(source)
            override fun newArray(size: Int): Array<Event?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readInt() == 1,
            source.readParcelable<Actor>(Actor::class.java.classLoader),
            source.readParcelable<Repository>(Repository::class.java.classLoader),
            source.readParcelable<Organization>(Organization::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(type)
        writeString(creationDate)
        writeInt((if (public) 1 else 0))
        writeParcelable(actor, 0)
        writeParcelable(repository, 0)
        writeParcelable(organization, 0)
    }

    // endregion
}
