package com.github.feed.sample.ext

import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.github.feed.sample.R
import com.github.feed.sample.ui.common.GlideApp

fun ImageView.loadCircleImage(url: String?) {
    GlideApp.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_github_circle)
            .circleCrop()
            .transition(withCrossFade())
            .into(this)
}
