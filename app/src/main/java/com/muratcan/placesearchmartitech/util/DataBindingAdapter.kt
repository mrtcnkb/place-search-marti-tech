package com.muratcan.placesearchmartitech.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Created by MuratCan on 2019-10-20.
 */

object DataBindingAdapter {

    @JvmStatic
    @BindingAdapter("loadPhoto")
    fun loadImage(view: ImageView, photoUrl: String?) {
        photoUrl?.let {
            view.loadImage(it)
        }
    }

}