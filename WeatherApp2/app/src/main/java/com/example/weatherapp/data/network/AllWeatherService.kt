package com.example.weatherapp.data.network

import com.example.weatherapp.data.model.AllWeatherResponse
import com.example.weatherapp.enums.Enum
import com.example.weatherapp.utils.getDate
import com.example.weatherapp.utils.initRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AllWeatherService @Inject constructor(){

    private var retrofit = initRetrofit()

    suspend fun getAllWeather() : AllWeatherResponse? {
        val date = getDate()
        val url = "v1/history.json?key=${Enum.API_KEY.value}&q=${Enum.Q.value}&dt=${date}"
        return withContext(Dispatchers.IO){
            val response = retrofit.create(AllWeatherApiClient::class.java).getAllWeather(url)
            response.body()
        }
    }
}