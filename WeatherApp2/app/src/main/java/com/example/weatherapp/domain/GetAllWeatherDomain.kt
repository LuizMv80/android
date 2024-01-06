package com.example.weatherapp.domain

import com.example.weatherapp.data.AllWeatherRepository
import com.example.weatherapp.data.model.AllWeatherResponse
import javax.inject.Inject

class GetAllWeatherDomain @Inject constructor (
    private val repository: AllWeatherRepository
){
    suspend operator fun invoke() : AllWeatherResponse? = repository.getAllWeather()
}