package com.example.weatherapp.data.network

import retrofit2.http.Url
import retrofit2.Response
import retrofit2.http.GET
import com.example.weatherapp.data.model.CurrentWeather

interface CurrentWeatherApiClient  {
    @GET
    suspend fun getCurrentWeather(@Url url: String) : Response<CurrentWeather>
}