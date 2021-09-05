package com.example.android_structure.data.repository.source.remote

import com.example.android_structure.data.repository.source.MovieDataSource
import com.example.android_structure.data.repository.source.remote.api.ApiService

class MovieRemoteImpl(private val apiService: ApiService) : MovieDataSource.Remote {

    override suspend fun getMovies() = apiService.getTopRated()
}
