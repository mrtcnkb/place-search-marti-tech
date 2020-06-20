package com.muratcan.model.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.DecimalFormat

@Parcelize
data class Result(
    val business_status: String,
    val formatted_address: String,
    val geometry: Geometry,
    val icon: String,
    val id: String,
    val name: String,
    val opening_hours: OpeningHours,
    val photos: List<Photo>,
    val place_id: String,
    val plus_code: PlusCode,
    val price_level: Int,
    val rating: Double,
    val reference: String,
    val types: List<String>,
    val user_ratings_total: Int
): Parcelable {
    fun getRatingBarValue(): Float{
        DecimalFormat("0.0").apply {
            return this.format(rating).replace(',','.').toFloat()
        }
    }

    fun getRatingTotal() =
        user_ratings_total.toString()
}