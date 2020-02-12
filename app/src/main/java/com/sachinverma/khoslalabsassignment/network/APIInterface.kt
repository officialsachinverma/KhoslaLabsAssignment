package com.sachinverma.khoslalabsassignment.network

import com.sachinverma.khoslalabsassignment.model.Response
import com.sachinverma.khoslalabsassignment.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Sachin Verma on 2020-02-11.
 */

interface APIInterface {

    @GET(Constants.API_CURRENT_WEATHER)
    fun doGetNewsList(@QueryMap params: Map<String, String>): Call<Response>

}