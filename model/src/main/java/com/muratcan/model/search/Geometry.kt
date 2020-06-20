package com.muratcan.model.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Geometry(
    val location: Location,
    val viewport: Viewport
): Parcelable