package com.example.weatherapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapp.data.model.Current
import com.example.weatherapp.data.model.Location

@Entity(tableName = "weather_table")
data class WeatherEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name="temp")
    val temp: String,
    @ColumnInfo(name="humidity")
    val humidity: String,
    @ColumnInfo(name="country")
    val country: String
)
