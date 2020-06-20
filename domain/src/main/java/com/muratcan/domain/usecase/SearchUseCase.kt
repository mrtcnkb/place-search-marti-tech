package com.muratcan.domain.usecase

import com.muratcan.data.repository.PlaceSearchRepository

/**
 * Created by MuratCan on 18.06.2020.
 */
class SearchUseCase(private val repository: PlaceSearchRepository) {

    suspend fun fetchSearchedPlaces(input: String) =
        repository.fetchSearchedPlaces(input = input)

}