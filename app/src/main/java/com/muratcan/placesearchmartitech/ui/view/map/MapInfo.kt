package com.muratcan.placesearchmartitech.ui.view.map

import com.google.android.gms.maps.model.LatLng

/**
 * Created by MuratCan on 20.06.2020.
 */

data class MapInfo(
    val latLng: LatLng,
    val title: String,
    val snipped: String
)