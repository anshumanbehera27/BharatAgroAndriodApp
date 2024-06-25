package com.anshuman.bharatagro.Activitys

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anshuman.bharatagro.R
import com.anshuman.bharatagro.databinding.ActivityWeatherBinding
import okhttp3.Request
import org.json.JSONException
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

class WeatherActivity : AppCompatActivity() {
// TODO Chnage the date formate and the start date and end date

   lateinit var searchBar: EditText
   lateinit var btn_weather: Button
    lateinit var current_temp: TextView
    lateinit var feels_like_temp: TextView
    lateinit var weather_condition: TextView
    lateinit var pressure_text: TextView
    lateinit var humidity_text: TextView
    lateinit var wind_speed: TextView
    lateinit var sunrise: TextView
    lateinit var sunset: TextView
    lateinit var temp_fahrenheit: TextView
    lateinit var dateTime: TextView


    private val url = "https://api.openweathermap.org/data/2.5/weather"
    private val appid = "9866b4b071f694f7bc7c545fb837b1bc"
    private val df = DecimalFormat("#.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_weather)

        searchBar = findViewById(R.id.search_bar)
        btn_weather = findViewById(R.id.btn_weather)
        current_temp = findViewById(R.id.current_temp)
        feels_like_temp = findViewById(R.id.feels_like_temp)
        weather_condition = findViewById(R.id.weather_condition)
        pressure_text = findViewById(R.id.pressure)
        humidity_text = findViewById(R.id.humidity)
        wind_speed = findViewById(R.id.wind_speed)
        sunrise = findViewById(R.id.sunrise)
        sunset = findViewById(R.id.sunset)
        temp_fahrenheit = findViewById(R.id.temp_fahrenheit)

        dateTime = findViewById(R.id.date_time)




    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeatherDetails(view: View) {
        var tempUrl = ""
        var city = searchBar.text.toString()

        if (city.isEmpty()) {
             searchBar.error = "Please enter a city name"
            Toast.makeText(this , "please enter a city name" , Toast.LENGTH_SHORT).show()
        } else {
            tempUrl = "$url?q=$city&appid=$appid"
            }

            val stringRequest = StringRequest(com.android.volley.Request.Method.GET, tempUrl,
                { response ->
                    try {
                        val jsonResponse = JSONObject(response)
                        val jsonArray = jsonResponse.getJSONArray("weather")
                        val jsonObjectWeather = jsonArray.getJSONObject(0)
                        val description = jsonObjectWeather.getString("description")
                        val jsonObjectMain = jsonResponse.getJSONObject("main")
                        val temp = jsonObjectMain.getDouble("temp") - 273.15
                        val feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15
                        val pressure = jsonObjectMain.getInt("pressure").toFloat()
                        val humidity = jsonObjectMain.getInt("humidity")
                        val jsonObjectWind = jsonResponse.getJSONObject("wind")
                        val wind = jsonObjectWind.getString("speed")
                        val jsonObjectSys = jsonResponse.getJSONObject("sys")
                        //val countryName = jsonObjectSys.getString("country")
                        //val cityName = jsonResponse.getString("name")

                        // Update individual TextViews
                        dateTime.text = LocalDateTime.now().toString().trim { it <= ' ' }
                        current_temp.text = "${df.format(temp)} °C"
                        feels_like_temp.text = "${df.format(feelsLike)} °C"
                        weather_condition.text = description
                        pressure_text.text = "$pressure hPa"
                        humidity_text.text = "$humidity%"
                        wind_speed.text = "$wind m/s"
                        // Calculate sunrise and sunset times (assuming they are in UNIX time)
                        val sunriseTime = jsonObjectSys.getLong("sunrise")
                        val sunsetTime = jsonObjectSys.getLong("sunset")
                        val sunriseDate = Date(sunriseTime * 1000)
                        val sunsetDate = Date(sunsetTime * 1000)
                        val timeFormatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                        sunrise.text = timeFormatter.format(sunriseDate)
                        sunset.text = timeFormatter.format(sunsetDate)

                        // Convert temp to Fahrenheit
                        val tempFahrenheit = temp * 9/5 + 32
                        temp_fahrenheit.text = "${df.format(tempFahrenheit)} °F"


                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                { error ->
                    Toast.makeText(applicationContext, error.toString().trim { it <= ' ' }, Toast.LENGTH_SHORT).show()
                })

            val requestQueue: RequestQueue = Volley.newRequestQueue(applicationContext)
            requestQueue.add(stringRequest)
        }
    }










