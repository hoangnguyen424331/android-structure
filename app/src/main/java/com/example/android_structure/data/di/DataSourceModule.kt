package com.example.android_structure.data.di

import com.example.android_structure.data.repository.source.MovieDataSource
import com.example.android_structure.data.repository.source.local.MovieLocalImpl
import com.example.android_structure.data.repository.source.remote.MovieRemoteImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<MovieDataSource.Local> {
        MovieLocalImpl()
    }

    single<MovieDataSource.Remote> {
        MovieRemoteImpl(apiService = get())
    }
}
