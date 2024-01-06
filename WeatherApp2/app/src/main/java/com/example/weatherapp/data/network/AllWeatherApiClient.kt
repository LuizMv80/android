package com.example.weatherapp.data.network

import com.example.weatherapp.data.model.AllWeatherResponse
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Url

interface AllWeatherApiClient {
    @GET
    suspend fun getAllWeather(@Url url: String) : Response<AllWeatherResponse>
}