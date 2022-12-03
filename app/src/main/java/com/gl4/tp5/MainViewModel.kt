package com.gl4.tp5

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    val weather: MutableLiveData<WeatherResponse> by lazy {
        MutableLiveData<WeatherResponse>()
    }
    init {
        getWeather()
    }

    private fun getWeather() {
        RetrofitHelper.retrofitService.getWeather().enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful) {
                    weather.value = response.body()
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("FAILED",t.message.toString())
            }
        })
    }
}