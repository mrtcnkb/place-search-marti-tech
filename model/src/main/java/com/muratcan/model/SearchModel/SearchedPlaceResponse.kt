package com.muratcan.model.SearchModel

data class SearchedPlaceResponse(
    val next_page_token: String,
    val results: List<Result>,
    val status: String
)