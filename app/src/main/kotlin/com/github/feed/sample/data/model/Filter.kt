package com.github.feed.sample.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
data class Filter(

        @Id
        var id: Long = 0,

        @Index
        val name: String,

        var checked: Boolean
)
