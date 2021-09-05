package com.example.android_structure.utils.di

import android.app.Application
import com.example.android_structure.data.di.dataSourceModule
import com.example.android_structure.data.di.networkModule
import com.example.android_structure.data.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val modules = listOf(
            appModule,
            dataSourceModule,
            networkModule,
            repositoryModule,
            viewModelModule
        )
        startKoin {
            Level.ERROR
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}
