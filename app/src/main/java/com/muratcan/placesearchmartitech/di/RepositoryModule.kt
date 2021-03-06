package com.muratcan.placesearchmartitech.di

import com.muratcan.data.repository.PlaceSearchRepository
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by MuratCan on 18.06.2020.
 */

val repositoryModule: Module = module {
    single { PlaceSearchRepository(get()) }
}