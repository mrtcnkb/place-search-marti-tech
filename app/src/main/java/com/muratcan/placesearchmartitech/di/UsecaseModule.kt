package com.muratcan.placesearchmartitech.di

import com.muratcan.domain.usecase.SearchUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by MuratCan on 18.06.2020.
 */

val usecaseModule: Module = module {
    single { SearchUseCase(get()) }
}