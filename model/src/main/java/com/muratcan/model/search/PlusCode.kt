package com.muratcan.model.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlusCode(
    val compound_code: String,
    val global_code: String
): Parcelable