package com.example.weatherapp.utils


import retrofit2.Retrofit
import com.example.weatherapp.enums.Enum
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun initRetrofit() : Retrofit {
    return Retrofit.Builder().baseUrl(Enum.WEATHER_URL_BASE.value)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}


fun getDate() : String {
    val calendario = Calendar.getInstance()
    val formatoFecha = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return formatoFecha.format(calendario.time)
}