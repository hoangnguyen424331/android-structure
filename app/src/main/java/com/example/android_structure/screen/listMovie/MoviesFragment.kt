package com.example.android_structure.screen.listMovie

import android.view.LayoutInflater
import androidx.lifecycle.Observer
import com.example.android_structure.data.model.Movie
import com.example.android_structure.databinding.FragmentMoviesBinding
import com.example.android_structure.screen.listMovie.adapter.MoviesAdapter
import com.example.android_structure.utils.OnItemClickListener
import com.example.android_structure.utils.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>(),
    OnItemClickListener<Movie> {

    private var adapter: MoviesAdapter? = null

    override val viewModel: MoviesViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) =
        FragmentMoviesBinding.inflate(inflater)

    override fun initView() {
        viewBinding.lifecycleOwner = this.viewLifecycleOwner
        viewBinding.viewModel = viewModel
    }

    override fun initData() {
        adapter = MoviesAdapter().apply {
            registerItemClickListener(this@MoviesFragment)
        }
        recyclerViewMovie.adapter = adapter
    }

    override fun onItemViewClick(item: Movie, position: Int) {}

    override fun onStop() {
        adapter?.unRegisterItemClickListener()
        super.onStop()
    }

    override fun registerLiveData() = with(viewModel) {
        super.registerLiveData()
        movies.observe(viewLifecycleOwner, Observer(::updateMovies))
    }

    private fun updateMovies(movies: MutableList<Movie>) {
        adapter?.updateData(movies)
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}
