package com.muratcan.placesearchmartitech.di

import com.muratcan.placesearchmartitech.viewmodel.VMMarkerDetail
import com.muratcan.placesearchmartitech.viewmodel.VMSearchFragment
import com.muratcan.placesearchmartitech.viewmodel.VMSearchResultMap
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by MuratCan on 18.06.2020.
 */

val viewModelModule: Module = module {
    viewModel { VMSearchFragment(get()) }
    viewModel { VMSearchResultMap() }
    viewModel { VMMarkerDetail() }
}