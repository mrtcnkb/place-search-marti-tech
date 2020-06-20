package com.muratcan.model.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val lat: Double,
    val lng: Double
): Parcelable {
    fun getFormattedLat() = lat.toString()
    fun getFormattedLng() = lng.toString()
}