package com.example.weatherapp.data.model

data class Current (
    val last_updated_epoch: Long,
    val last_updated: String,
    val temp_c: Double,
    val wind_mph: Double,
    val pressure_mb: Double,
    val humidity: Int,
    val cloud: Int,
    val uv: Double
)