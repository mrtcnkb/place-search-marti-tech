package com.muratcan.placesearchmartitech.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muratcan.model.search.Result

class VMSearchResultMap : ViewModel() {

    var searchData = MutableLiveData<Result>()

}