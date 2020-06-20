package com.muratcan.placesearchmartitech.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratcan.domain.usecase.SearchUseCase
import com.muratcan.model.search.SearchedPlaceResponse
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class VMSearchFragment(private val useCase: SearchUseCase) : ViewModel(), KoinComponent {

    var searchResult = MutableLiveData<SearchedPlaceResponse>()

    fun fetchResult(input: String) {
        viewModelScope.launch {
            useCase.fetchSearchedPlaces(input).let {
                searchResult.value = it
            }
        }
    }
}