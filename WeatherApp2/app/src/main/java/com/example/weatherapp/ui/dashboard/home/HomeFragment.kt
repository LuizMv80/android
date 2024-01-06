package com.example.weatherapp.ui.dashboard.home

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.data.database.entities.WeatherEntity
import dagger.hilt.android.AndroidEntryPoint
import com.example.weatherapp.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: VMHome by viewModels()

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.created()
        viewModel.currentWeather.observe(viewLifecycleOwner, Observer {
            binding.uv.text = it?.current?.uv.toString()
            binding.currentTemp.text = it?.current?.temp_c.toString()
            binding.humidity.text = it?.current?.humidity.toString()
            binding.location.text = it?.location?.country.toString()
        })

        binding.imageView2.setOnClickListener {
            viewModel.saveCurrentWeather(createCurrentWeather())
            Toast.makeText(requireContext(), "Data saved!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun createCurrentWeather(): WeatherEntity {
        return WeatherEntity(
            temp = binding.currentTemp.text.toString(),
            humidity = binding.humidity.text.toString(),
            country = binding.location.text.toString()
        )
    }
}
