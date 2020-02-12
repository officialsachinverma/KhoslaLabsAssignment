package com.sachinverma.khoslalabsassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sachinverma.khoslalabsassignment.model.WeatherForecast
import com.sachinverma.khoslalabsassignment.ui.adapter.viewholder.WeatherForecastViewHolder

/**
 * Created by Sachin Verma on 2020-02-11.
 */

class WeatherForecastAdapter (private val view: Int) : ListAdapter<WeatherForecast, WeatherForecastViewHolder>(WeatherForecastDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = WeatherForecastViewHolder(LayoutInflater.from(parent.context).inflate(view, parent, false))

    override fun onBindViewHolder(holder: WeatherForecastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WeatherForecastDiffUtil: DiffUtil.ItemCallback<WeatherForecast>() {

        override fun areItemsTheSame(oldItem: WeatherForecast, newItem: WeatherForecast): Boolean {
            return oldItem.dt == newItem.dt
        }

        override fun areContentsTheSame(oldItem: WeatherForecast, newItem: WeatherForecast): Boolean {
            return oldItem == newItem
        }

    }

}