package com.muratcan.placesearchmartitech.util

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muratcan.placesearchmartitech.R

/**
 * Created by MuratCan on 18.06.2020.
 */

fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, Observer {
        it?.let(observer)
    })
}

fun ImageView.loadImage(uri: Any) {
    Glide.with(this.context)
        .load(uri)
        .into(this)
}