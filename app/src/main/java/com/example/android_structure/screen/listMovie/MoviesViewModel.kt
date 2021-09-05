package com.example.android_structure.screen.listMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_structure.data.MovieRepository
import com.example.android_structure.data.model.Movie
import com.example.android_structure.utils.base.BaseViewModel

class MoviesViewModel(private val movieRepository: MovieRepository) : BaseViewModel() {

    private val _movies = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>>
        get() = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope(
            onRequest = { movieRepository.getMovies() },
            onSuccess = {
                _movies.value = it
            },
            onError = {
                exception.value = it
            })
    }
}
