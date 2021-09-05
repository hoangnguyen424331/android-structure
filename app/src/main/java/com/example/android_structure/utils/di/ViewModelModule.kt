package com.example.android_structure.utils.di

import com.example.android_structure.screen.listMovie.MoviesViewModel
import com.example.android_structure.screen.main.MainViewModel
import org.koin.dsl.module

val viewModelModule= module {

    single { MainViewModel() }

    single { MoviesViewModel(get()) }
}
