package com.example.weatherapp.ui.dashboard.home

import javax.inject.Inject
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.data.database.entities.WeatherEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.domain.CurrentWeatherDomain

@HiltViewModel
class VMHome @Inject constructor (
    private val currentWeatherDomain: CurrentWeatherDomain
) : ViewModel(){

    val currentWeather = MutableLiveData<CurrentWeather?>()

    fun created(){
        viewModelScope.launch {
            val response: CurrentWeather? = currentWeatherDomain()
            response.let {
                currentWeather.postValue(response)
            }
        }
    }


    fun saveCurrentWeather(data: WeatherEntity){
        viewModelScope.launch {
            currentWeatherDomain.saveWeather(data)
        }
    }


}