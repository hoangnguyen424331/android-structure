package com.example.android_structure.data.repository

import androidx.lifecycle.LiveData
import com.example.android_structure.data.MovieRepository
import com.example.android_structure.data.model.Movie
import com.example.android_structure.data.repository.source.MovieDataSource
import com.example.android_structure.utils.base.BaseRepository

class MovieRepositoryImpl(
    private val remote: MovieDataSource.Remote,
    private val local: MovieDataSource.Local
) : BaseRepository(), MovieRepository {

    override suspend fun getMovieLocal(): LiveData<MutableList<Movie>> = local.getMovieLocal()

    override suspend fun getMovies() = withResultContext {
        remote.getMovies().data
    }
}
