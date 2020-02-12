package com.sachinverma.khoslalabsassignment.model

/**
 * Created by Sachin Verma on 2020-02-11.
 */

data class City(var id: Int,
                var name: String,
                var coord: Coordinates,
                var country: String,
                var timezone: Int,
                var sunrise: Long,
                var sunset: Long)