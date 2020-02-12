package com.sachinverma.khoslalabsassignment.ui.activity

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.sachinverma.khoslalabsassignment.R
import com.sachinverma.khoslalabsassignment.ui.activity.viewmodel.WeatherForecastViewModel
import com.sachinverma.khoslalabsassignment.ui.adapter.WeatherForecastAdapter
import com.sachinverma.khoslalabsassignment.util.UtilityFunctions


class WeatherForecastActivity : AppCompatActivity() {


    @BindView(R.id.rv_weather_list)
    lateinit var rvWeatherList: RecyclerView

    @BindView(R.id.empty_msg)
    lateinit var tvEmptyList: TextView

    @BindView(R.id.main_temp)
    lateinit var tvMainTemp: TextView

    @BindView(R.id.try_againMsg)
    lateinit var tvtryAgain: TextView

    @BindView(R.id.pg_waiting_sign)
    lateinit var waitingSign: ProgressBar

    private lateinit var weatherForecastViewModel: WeatherForecastViewModel
    private lateinit var adapter: WeatherForecastAdapter

    private lateinit var slideUp: Animation
    private lateinit var slideDown: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        init()

        if (UtilityFunctions.isNetworkAvailable(this))
            weatherForecastViewModel.loadData()
        else {
            Toast.makeText(this, "No internet connectivity", Toast.LENGTH_SHORT).show()
            hideWaitingSign()
            hideEmptyMsg()
            hideList()
            showRetrySign()
        }
    }

    private fun init() {

        weatherForecastViewModel = ViewModelProvider(this).get(WeatherForecastViewModel::class.java)

        tvtryAgain.setOnClickListener {
            showWaitingSign()
            hideList()
            hideRetrySign()
            weatherForecastViewModel.loadData()
        }

        slideUp = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_up)
        slideDown = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_down)

        initAdapter()

        observeForObservable()
    }

    private fun initAdapter() {
        adapter = WeatherForecastAdapter(R.layout.row_weather)
        val linearLayout = LinearLayoutManager(this)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        rvWeatherList.layoutManager = linearLayout
        rvWeatherList.adapter = adapter
    }

    private fun observeForObservable() {
        weatherForecastViewModel.weatherForecastList.observe(this, Observer {
            hideWaitingSign()
            if (it.list.isNotEmpty()) {
                showList()
                adapter.submitList(it.list)
                tvMainTemp.text = "${it.list[0].main.temp}\u00B0C \n ${it.city.name}"
            } else {
                hideList()
                showRetrySign()
            }
        })

        weatherForecastViewModel.errorMsg.observe(this, Observer {
            hideWaitingSign()
            hideEmptyMsg()
            hideList()
            showRetrySign()
        })
    }

    private fun showWaitingSign() {
        waitingSign.visibility = View.VISIBLE
    }

    private fun hideWaitingSign() {
        waitingSign.visibility = View.GONE
    }

    private fun showEmptyMsg() {
        tvEmptyList.visibility = View.VISIBLE
    }

    private fun hideEmptyMsg() {
        tvEmptyList.visibility = View.GONE
    }

    private fun showList() {
        rvWeatherList.visibility = View.VISIBLE
        rvWeatherList.startAnimation(slideUp)
    }

    private fun hideList() {
        rvWeatherList.startAnimation(slideDown)
        rvWeatherList.visibility = View.GONE
    }

    private fun showRetrySign() {
        tvtryAgain.visibility = View.VISIBLE
    }

    private fun hideRetrySign() {
        tvtryAgain.visibility = View.GONE
    }
}
