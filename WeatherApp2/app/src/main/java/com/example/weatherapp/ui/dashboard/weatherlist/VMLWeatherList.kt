package com.example.weatherapp.ui.dashboard.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.Hour
import com.example.weatherapp.domain.GetAllWeatherDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VMLWeatherList @Inject constructor (
    private val getAllWeatherDomain: GetAllWeatherDomain
) : ViewModel() {

    val weatherList = MutableLiveData<List<Hour>>()
    val progress = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            val result = getAllWeatherDomain()
            if(result != null){
                val hourList = result.forecast.forecastday.first().hour
                weatherList.postValue(hourList)
                progress.postValue(false)
            }

        }
    }
}