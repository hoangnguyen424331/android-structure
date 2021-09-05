package com.example.android_structure.data

import androidx.lifecycle.LiveData
import com.example.android_structure.data.model.Movie
import com.example.android_structure.utils.scheduler.DataResult

interface MovieRepository {

    suspend fun getMovieLocal(): LiveData<MutableList<Movie>>

    suspend fun getMovies(): DataResult<MutableList<Movie>>
}
