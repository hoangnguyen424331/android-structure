package com.example.android_structure.screen.main

import android.view.LayoutInflater
import com.example.android_structure.R
import com.example.android_structure.databinding.ActivityMainBinding
import com.example.android_structure.screen.listMovie.MoviesFragment
import com.example.android_structure.utils.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    override fun inflateBinding(inflater: LayoutInflater) = ActivityMainBinding.inflate(inflater)

    override fun initView() {
        viewBinding.lifecycleOwner = this
        viewBinding.viewModel = viewModel

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(MoviesFragment::javaClass.name)
            .replace(R.id.layoutContainer,MoviesFragment.newInstance())
            .commit()
    }

    override fun initData() {}
}
