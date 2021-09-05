package com.example.android_structure.data.repository.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.android_structure.data.model.Movie
import com.example.android_structure.data.repository.source.MovieDataSource

class MovieLocalImpl : MovieDataSource.Local {

    override suspend fun getMovieLocal(): LiveData<MutableList<Movie>> {
        return liveData { mutableListOf<Movie>() }
    }
}
