package com.example.android_structure.screen.listMovie.adapter

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.example.android_structure.data.model.Movie

class MoviesDiffUtil(
    @Nullable private var oldItems: MutableList<Movie>,
    @Nullable private var newsItems: MutableList<Movie>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newsItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition].id == newsItems[newItemPosition].id
                && oldItems[oldItemPosition].title == newsItems[newItemPosition].title

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition] == newsItems[newItemPosition]
}
