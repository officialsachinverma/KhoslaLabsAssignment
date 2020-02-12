package com.sachinverma.khoslalabsassignment.ui.activity.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sachinverma.khoslalabsassignment.model.Response
import com.sachinverma.khoslalabsassignment.model.WeatherForecast
import com.sachinverma.khoslalabsassignment.network.APIClient
import com.sachinverma.khoslalabsassignment.network.APIInterface
import com.sachinverma.khoslalabsassignment.util.Constants
import com.sachinverma.khoslalabsassignment.util.Logger
import com.sachinverma.khoslalabsassignment.util.UtilityFunctions
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Sachin Verma on 2020-02-11.
 */

class WeatherForecastViewModel: ViewModel() {

    var apiInterface: APIInterface? = null

    private var _weatherForecastList = MutableLiveData<Response>()
    val weatherForecastList: LiveData<Response>
        get() = _weatherForecastList

    private var _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String>
        get() = _errorMsg

    private val callback = object : Callback<Response> {

        override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
            Logger.i("network response : ${response.body()}")
            val temp = response.body() as Response
            _weatherForecastList.value = temp
        }

        override fun onFailure(call: Call<Response>, t: Throwable) {
            Logger.i("network onFailure : ${t.printStackTrace()}")
            _errorMsg.value = "Network Error Occurred"
        }
    }

    fun loadData () {
        apiInterface = APIClient.getClient()!!.create(APIInterface::class.java)

        val params = HashMap<String, String>()

        params["id"] = "1277333"

        params["appid"] = Constants.API_ACCESS_KEY

        params["units"] = "metric"

        val call: Call<Response> = apiInterface!!.doGetNewsList(params)

        call.enqueue(callback)
    }

}