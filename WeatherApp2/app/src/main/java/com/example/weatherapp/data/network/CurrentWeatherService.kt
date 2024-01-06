package com.example.weatherapp.data.network

import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.enums.Enum
import com.example.weatherapp.utils.initRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CurrentWeatherService @Inject constructor(){
    private val retrofit = initRetrofit()

    suspend fun getCurrentWeather() : CurrentWeather? {
        val url = "v1/current.json?key=${Enum.API_KEY.value}&q=${Enum.Q.value}"
        return withContext(Dispatchers.IO){
            val response = retrofit.create(CurrentWeatherApiClient::class.java).getCurrentWeather(url)
            response.body()
        }
    }
}
