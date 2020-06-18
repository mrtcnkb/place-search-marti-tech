package com.muratcan.placesearchmartitech.di

import com.muratcan.data.api.provideOkhttpClient
import com.muratcan.data.api.provideRetrofit
import com.muratcan.data.api.provideService
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by MuratCan on 18.06.2020.
 */

val networkModule: Module = module {
    single { provideOkhttpClient() }
    single { provideRetrofit(get()) }
    single { provideService(get()) }
}