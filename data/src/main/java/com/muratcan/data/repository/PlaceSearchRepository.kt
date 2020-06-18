package com.muratcan.data.repository

import com.muratcan.data.api.RestServiceInterface
import com.muratcan.model.SearchModel.SearchedPlaceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by MuratCan on 18.06.2020.
 */

class PlaceSearchRepository(private val restInterface: RestServiceInterface) {

    suspend fun fetchSearchedPlaces(input: String): SearchedPlaceResponse? {
        return withContext(Dispatchers.IO) {
            try {
                return@withContext restInterface.fetchSearchedPlaces(input = input)
            }catch (e: Exception){
                e.printStackTrace()
                return@withContext null
            }
        }
    }

}