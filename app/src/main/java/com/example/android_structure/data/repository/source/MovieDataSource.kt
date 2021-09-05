package com.example.android_structure.data.repository.source

import androidx.lifecycle.LiveData
import com.example.android_structure.data.model.Movie
import com.example.android_structure.data.repository.source.remote.api.response.BaseResponse

interface MovieDataSource {

    interface Local {
        suspend fun getMovieLocal(): LiveData<MutableList<Movie>>
    }

    interface Remote {
        suspend fun getMovies(): BaseResponse<MutableList<Movie>>
    }
}
