package com.example.weatherapp.domain

import javax.inject.Inject
import com.example.weatherapp.data.CurrentWeatherRepository
import com.example.weatherapp.data.database.entities.WeatherEntity

class CurrentWeatherDomain @Inject constructor (
    private val currentWeatherRepository : CurrentWeatherRepository,
) {
    suspend operator fun invoke() = currentWeatherRepository.getCurrentWeather()
    suspend fun saveWeather(data: WeatherEntity) = currentWeatherRepository.saveWeather(data)
}