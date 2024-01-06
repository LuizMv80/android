package com.example.weatherapp.data

import com.example.weatherapp.data.database.dao.WeatherDao
import com.example.weatherapp.data.database.entities.WeatherEntity
import javax.inject.Inject
import com.example.weatherapp.data.network.CurrentWeatherService

class CurrentWeatherRepository @Inject constructor(
    private val apiCurrentWeather: CurrentWeatherService,
    private val weatherDao: WeatherDao
){
    suspend fun getCurrentWeather() = apiCurrentWeather.getCurrentWeather()
    suspend fun saveWeather(data: WeatherEntity) = weatherDao.postWeather(data)
}