package com.example.weatherapp.ui.dashboard.weatherlist

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.weatherapp.data.model.Hour
import com.example.weatherapp.adapters.WeatherAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.FragmentAllWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllWeatherFragment : Fragment() {

    private lateinit var adapter: WeatherAdapter
    private var weatherList = mutableListOf<Hour>()
    private lateinit var binding: FragmentAllWeatherBinding
    private val viewModel: VMLWeatherList by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllWeatherBinding.inflate(inflater, container, false)
        viewModel.onCreate()
        viewModel.weatherList.observe(viewLifecycleOwner, Observer{
            weatherList = it.toMutableList()
            initRecyclerView()
        })

        viewModel.progress.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })
        return binding.root
    }

    private fun initRecyclerView() {
        adapter = WeatherAdapter(weatherList)
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleView.adapter = adapter
    }
}