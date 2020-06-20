package com.muratcan.data.api

import com.muratcan.data.BuildConfig
import com.muratcan.model.search.SearchedPlaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by MuratCan on 18.06.2020.
 */
interface RestServiceInterface {

    @GET("place/textsearch/json")
    suspend fun fetchSearchedPlaces(
        @Query("input") input: String,
        @Query("key") key: String? = BuildConfig.API_KEY,
        @Query("inputtype") inputType: String? = "textquery"
    ): SearchedPlaceResponse

}