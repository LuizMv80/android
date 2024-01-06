package com.example.weatherapp.data

import javax.inject.Inject
import com.example.weatherapp.data.model.AllWeatherResponse
import com.example.weatherapp.data.network.AllWeatherService

class AllWeatherRepository @Inject constructor(
    private val apiAllWeather : AllWeatherService
){
    suspend fun getAllWeather() : AllWeatherResponse? = apiAllWeather.getAllWeather()
}