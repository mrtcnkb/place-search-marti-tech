package com.muratcan.domain.usecase

import com.muratcan.data.repository.PlaceSearchRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by MuratCan on 18.06.2020.
 */
class SearchUseCase(private val repository: PlaceSearchRepository) {

    fun fetchSearchedPlaces(input: String) =
        GlobalScope.launch {
            repository.fetchSearchedPlaces(input = input).let {

            }
        }

}