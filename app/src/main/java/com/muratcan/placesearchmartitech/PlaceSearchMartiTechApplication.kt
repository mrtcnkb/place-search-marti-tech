package com.muratcan.placesearchmartitech

import android.app.Application
import android.content.Context
import com.muratcan.placesearchmartitech.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by MuratCan on 18.06.2020.
 */
class PlaceSearchMartiTechApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PlaceSearchMartiTechApplication)
            modules(listOf(viewModelModule, networkModule, repositoryModule))
        }
    }

    init {
        instance = this
    }

    companion object {
        private var instance = PlaceSearchMartiTechApplication()
        val context: Context
            get() = instance.applicationContext
    }
}