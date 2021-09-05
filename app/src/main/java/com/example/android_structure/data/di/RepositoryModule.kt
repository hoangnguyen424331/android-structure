package com.example.android_structure.data.di

import com.example.android_structure.data.MovieRepository
import com.example.android_structure.data.repository.MovieRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(remote = get(), local = get())
    }
}
