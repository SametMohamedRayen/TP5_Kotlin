package com.gl4.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private val mainViewModel:MainViewModel by viewModels()
    private var temp : TextView = findViewById(R.id.temp)
    private var style : TextView = findViewById(R.id.style)
    private var humidity : TextView = findViewById(R.id.humidty)
    private var pressure : TextView = findViewById(R.id.pressure)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.weather.observe(this, Observer {
            if(it != null) {
                temp.text = it.main.temp.toString()
                //style.text = it.weather.descrition.toString()
                humidity.text = it.main.humidity.toString()
                pressure.text = it.main.pressure.toString()
            }
        })
    }
}