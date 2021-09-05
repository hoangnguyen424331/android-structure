package com.example.android_structure.data.repository.source.remote.api

import com.example.android_structure.data.model.Movie
import com.example.android_structure.data.repository.source.remote.api.response.BaseResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/top_rated?")
    suspend fun getTopRated(): BaseResponse<MutableList<Movie>>
}
