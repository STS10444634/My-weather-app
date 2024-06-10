package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myweatherapp.R

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TextViews for each day of the week
        val textView3: TextView = findViewById(R.id.textView3)
        val textView4: TextView = findViewById(R.id.textView4)
        val textView5: TextView = findViewById(R.id.textView5)
        val textView6: TextView = findViewById(R.id.textView6)
        val textView7: TextView = findViewById(R.id.textView7)
        val textView8: TextView = findViewById(R.id.textView8)
        val textView9: TextView = findViewById(R.id.textView9)
        val textView10: TextView = findViewById(R.id.textView10)

        // Button to navigate back to the main menu
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            // Navigate back to the main activity
            finish()
        }

        // Set the weather information for each day (hardcoded for demonstration)
        textView3.text = getString(R.string.information)
        textView4.text = getString(R.string.monday) + ": Sunny, 25°C"
        textView5.text = getString(R.string.tuesday) + ": Cloudy, 22°C"
        textView6.text = getString(R.string.wednesday) + ": Rainy, 20°C"
        textView7.text = getString(R.string.thursday) + ": Stormy, 18°C"
        textView8.text = getString(R.string.friday) + ": Sunny, 27°C"
        textView9.text = getString(R.string.saturday) + ": Partly Cloudy, 23°C"
        textView10.text = getString(R.string.sunday) + ": Sunny, 26°C"
    }
}
