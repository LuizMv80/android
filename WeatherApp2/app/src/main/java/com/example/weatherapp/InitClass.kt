package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.providers.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InitClass : Application() {
    companion object{
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}