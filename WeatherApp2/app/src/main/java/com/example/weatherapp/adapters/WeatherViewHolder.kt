package com.example.weatherapp.adapters

import android.view.View
import android.widget.TextView
import com.example.weatherapp.R
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.data.model.Hour

class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val uv = view.findViewById<TextView>(R.id.tvUv)
    private val temp = view.findViewById<TextView>(R.id.tvTemp)
    private val country = view.findViewById<TextView>(R.id.tvCountry)

    fun render(weather: Hour){
        temp.text = weather.temp_c.toString()
        country.text = weather.wind_mph.toString()
        uv.text = weather.condition.text
    }
}