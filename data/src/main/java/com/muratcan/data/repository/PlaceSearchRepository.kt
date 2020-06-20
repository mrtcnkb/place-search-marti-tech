package com.muratcan.data.repository

import com.muratcan.data.api.RestServiceInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by MuratCan on 18.06.2020.
 */

class PlaceSearchRepository(private val restInterface: RestServiceInterface) {

    suspend fun fetchSearchedPlaces(input: String) =
        withContext(Dispatchers.IO) {
            restInterface.fetchSearchedPlaces(input = input)
        }

}