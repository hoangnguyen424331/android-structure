package com.example.android_structure.screen.listMovie.adapter

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.example.android_structure.data.model.Movie
import com.example.android_structure.utils.OnItemClickListener

class ItemMoviesViewModel(private val itemClickListener: OnItemClickListener<Movie>? = null) :
    BaseObservable() {

    @Bindable
    var movie: Movie? = null

    fun setData(data: Movie?) {
        data?.let {
            movie = it
            notifyPropertyChanged(BR.movie)
        }
    }

    fun onItemClick(view: View) {
        itemClickListener?.let { listener ->
            movie?.let {
                listener.onItemViewClick(it)
            }
        }
    }
}
