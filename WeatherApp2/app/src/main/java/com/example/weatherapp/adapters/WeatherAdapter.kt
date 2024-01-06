package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Hour

class WeatherAdapter(private val weatherList: List<Hour>) : RecyclerView.Adapter<WeatherViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater =  LayoutInflater.from(parent.context)
        return WeatherViewHolder(layoutInflater.inflate(R.layout.item_weather, parent, false))
    }

    override fun getItemCount(): Int  = weatherList.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = weatherList[position]
        holder.render(item)
    }
}