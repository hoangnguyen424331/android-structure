package com.example.android_structure.utils.di

import com.example.android_structure.utils.Constant
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single { named(Constant.BASE_URL) }
}
