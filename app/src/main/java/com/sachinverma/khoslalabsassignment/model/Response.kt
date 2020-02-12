package com.sachinverma.khoslalabsassignment.model

/**
 * Created by Sachin Verma on 2020-02-11.
 */

data class Response(var cod: String,
                    var message: Int,
                    var list: List<WeatherForecast>,
                    var city: City)