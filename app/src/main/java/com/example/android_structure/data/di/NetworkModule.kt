package com.example.android_structure.data.di

import com.example.android_structure.data.repository.source.remote.api.ApiService
import com.example.android_structure.data.repository.source.remote.api.ServiceGenerator
import com.example.android_structure.data.repository.source.remote.api.middleware.InterceptorImpl
import com.example.android_structure.utils.Constant
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

private fun buildHttpLog(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}

val networkModule = module {

    single<Gson> {
        GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    single<Interceptor> {
        InterceptorImpl(application = get())
    }

    single {
        ServiceGenerator.generate(
            baseUrl = Constant.BASE_URL,
            serviceClass = ApiService::class.java,
            gson = get(),
            interceptors = listOf(buildHttpLog(), get())
        )
    }
}
