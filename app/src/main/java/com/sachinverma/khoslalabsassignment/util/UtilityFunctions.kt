package com.sachinverma.khoslalabsassignment.util

import android.content.Context
import android.net.ConnectivityManager
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Sachin Verma on 2020-02-11.
 */

object UtilityFunctions {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun formatDate(dateStr: String): String {
        val actualFormat = "yyyy-MM-dd HH:mm:ss"
        val oldformat = SimpleDateFormat(actualFormat)

        val date = oldformat.parse(dateStr)

        val requiredFormat = "dd-MM-yyyy"
        val nowformat = SimpleDateFormat(requiredFormat)

        return nowformat.format(date)
    }

}