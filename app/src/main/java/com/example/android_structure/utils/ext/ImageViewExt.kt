package com.example.android_structure.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.android_structure.R
import com.example.android_structure.utils.Constant

fun ImageView.loadImageWithUrl(url: String) {
    Glide.with(this)
        .load(Constant.BASE_URL_IMAGE + url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun ImageView.loadImageCircleWithUrl(url: String) {
    Glide.with(this)
        .load(Constant.BASE_URL_IMAGE + url)
        .circleCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(R.drawable.img_circle_default)
        .into(this)
}
