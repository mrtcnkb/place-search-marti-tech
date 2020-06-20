package com.muratcan.placesearchmartitech.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muratcan.model.search.Result

class VMMarkerDetail : ViewModel() {
    val markerData = MutableLiveData<Result>()

}