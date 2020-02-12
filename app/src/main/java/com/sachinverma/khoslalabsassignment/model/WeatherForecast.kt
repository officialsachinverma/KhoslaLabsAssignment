package com.sachinverma.khoslalabsassignment.model

/**
 * Created by Sachin Verma on 2020-02-11.
 */
data class WeatherForecast(var dt: String,
                           var main: Main,
                           var weather: List<Weather>,
                           var clouds: Cloud,
                           var wind: Wind,
                           var sys: Sys,
                           var dt_txt: String)