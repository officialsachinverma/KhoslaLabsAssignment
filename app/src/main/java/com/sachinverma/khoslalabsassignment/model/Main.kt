package com.sachinverma.khoslalabsassignment.model

/**
 * Created by Sachin Verma on 2020-02-11.
 */

data class Main(var temp: Float,
                var feels_like: Float,
                var temp_min: Float,
                var temp_max: Float,
                var pressure: Int,
                var sea_level: Int,
                var grnd_level: Int,
                var humidity: Int,
                var temp_kf: Float)