@file:Suppress("DEPRECATION")

package com.example.myweatherapp

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL

class WeatherActivity : AppCompatActivity() {

    private lateinit var cityEditText: EditText
    private lateinit var getWeatherButton: Button
    private lateinit var weatherTextView: TextView

    private val apiKey = "YOUR_API_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        cityEditText = findViewById(R.id.cityEditText)
        getWeatherButton = findViewById(R.id.getWeatherButton)
        weatherTextView = findViewById(R.id.weatherTextView)

        getWeatherButton.setOnClickListener {
            val city = cityEditText.text.toString()
            if (city.isNotEmpty()) {
                WeatherTask().execute(city)
            } else {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    inner class WeatherTask : AsyncTask<String, Void, String>() {

        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg params: String?): String? {
            val city = params[0]
            val response: String?
            try {
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$city&units=metric&appid=$apiKey").readText(
                    Charsets.UTF_8
                )
            } catch (e: Exception) {
                return null
            }
            return response
        }

        @SuppressLint("SetTextI18n")
        @Deprecated("Deprecated in Java")
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result != null) {
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val temp = main.getString("temp")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0).getString("description")

                weatherTextView.text = "Temperature: $temp°C\nCondition: $weather"
            } else {
                Toast.makeText(this@WeatherActivity, "City not found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

