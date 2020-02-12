package com.sachinverma.khoslalabsassignment.ui.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sachinverma.khoslalabsassignment.R
import com.sachinverma.khoslalabsassignment.model.WeatherForecast
import com.sachinverma.khoslalabsassignment.util.UtilityFunctions

/**
 * Created by Sachin Verma on 2020-02-11.
 */

class WeatherForecastViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {


    private var tvDate: TextView = itemView.findViewById(R.id.tv_date)
    private var tvClimate: TextView = itemView.findViewById(R.id.tv_climate)
    private var tvTemp: TextView = itemView.findViewById(R.id.tv_temperature)

    fun bind(weatherForecast: WeatherForecast) {

        tvDate.text = UtilityFunctions.formatDate(weatherForecast.dt_txt)
        tvClimate.text = weatherForecast.weather[0].main
        tvTemp.text = "${weatherForecast.main.temp_min}°C/${weatherForecast.main.temp_max}°C"

    }

}