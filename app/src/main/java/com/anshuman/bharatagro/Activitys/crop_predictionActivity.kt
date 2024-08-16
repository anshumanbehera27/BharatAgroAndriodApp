package com.anshuman.bharatagro.Activitys

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.bharatagro.R


import android.widget.TextView
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.RetryPolicy
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anshuman.bharatagro.databinding.ActivityCropPredictionBinding
import com.google.android.material.slider.Slider
import org.json.JSONException
import org.json.JSONObject

class crop_predictionActivity : AppCompatActivity() {
    /*
      todo 1  - how to store all the response from the slider
      todo 2 - how to call the api POST _
      todo 3 - how to featch the data and show in the Texview formate
     */
    // define all the variable
    lateinit var binding: ActivityCropPredictionBinding
    private val url = "https://agro-api-xnfo.onrender.com/predictcrop"


    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCropPredictionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Nitrogen

        binding.sliderNitrogen.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Store the final value and display it in the result TextView
                val finalSliderValue = slider.value
                binding.resultNitrogen.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })
        // Phosphorus
        binding.sliderPhosphorus.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }


            override fun onStopTrackingTouch(slider: Slider) {
                // Store the final value and display it in the result TextView
                val finalSliderValue = slider.value
                binding.resultPhosphorus.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })
        // Potassium
        binding.sliderPotassium.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Store the final value and display it in the result TextView
                val finalSliderValue = slider.value
                binding.resultPotassium.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })
        //  Temperature
        binding.sliderTemperature.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Store the final value and display it in the result TextView
                val finalSliderValue = slider.value
                binding.resultTemperature.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })
        // Humidity
        binding.sliderHumidity.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Store the final value and display it in the result TextView
                val finalSliderValue = slider.value
                binding.resultHumidity.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })
        // ph
        binding.sliderPh.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Store the final value and display it in the result TextView
                val finalSliderValue = slider.value
                binding.resultPh.text = String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })
        // Rainfall
        binding.sliderRainfall.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Store the final value and display it in the result TextView
                val finalSliderValue = slider.value
                binding.resultRainFall.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })


        // TODO 1 How to  get the Api call from this button
        binding.btnCropPrediction.setOnClickListener {
            val nitrogen = binding.resultNitrogen.text.toString().split(":")[1].trim()
            val phosphorus = binding.resultPhosphorus.text.toString().split(":")[1].trim()
            val potassium = binding.resultPotassium.text.toString().split(":")[1].trim()
            val temperature = binding.resultTemperature.text.toString().split(":")[1].trim()
            val humidity = binding.resultHumidity.text.toString().split(":")[1].trim()
            val ph = binding.resultPh.text.toString().split(":")[1].trim()
            val rainfall = binding.resultRainFall.text.toString().split(":")[1].trim()

            val url = "https://agro-api-xnfo.onrender.com/predictcrop"
            /// Ensure all required fields are available and valid
                if (ph.isEmpty()) {
                    binding.tvFinalResult.text = "pH value is missing."
                    Toast.makeText(this , "Ph is missing " ,Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

            val requestBody = JSONObject()
            try {
                requestBody.put("Nitrogen", nitrogen.toFloat().toDouble())
                requestBody.put("Phosphorus", phosphorus.toFloat().toDouble())
                requestBody.put("Potassium", potassium.toFloat().toDouble())
                requestBody.put("Temperature", temperature.toDouble())
                requestBody.put("Humidity", humidity.toDouble())
                requestBody.put("Ph", ph.toDouble())
                requestBody.put("Rainfall", rainfall.toDouble())
                println("Request Body: $requestBody")
            } catch (e: JSONException) {
                e.printStackTrace()
                binding.tvFinalResult.text = e.message
                return@setOnClickListener
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                binding.tvFinalResult.text = "Invalid number format in input fields."
                return@setOnClickListener
            }

            val jsonObjectRequest = object : JsonObjectRequest(
                Method.POST, url, requestBody,
                Response.Listener { response ->
                    try {
                        val cropPrediction = response.getString("predictcrop")
                        binding.tvFinalResult.text = cropPrediction
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        binding.tvFinalResult.text = e.message
                    }
                },
                Response.ErrorListener { error ->
                    error.printStackTrace()
                    val response = error.networkResponse
                    if (response != null && response.data != null) {
                        val errorResponse = String(response.data)
                        println("Error Response: $errorResponse")
                        binding.tvFinalResult.text = errorResponse
                    } else {
                        binding.tvFinalResult.text = error.message
                    }
                }
            ) {
                override fun getHeaders(): MutableMap<String, String> {
                    val headers = HashMap<String, String>()
                    headers["Content-Type"] = "application/json"
                    return headers
                }
            }

            // Increase the timeout for the request
            val socketTimeout = 30000  // 30 seconds. You can change this value as needed.
            val retryPolicy: RetryPolicy = DefaultRetryPolicy(
                socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            )
            jsonObjectRequest.retryPolicy = retryPolicy

            val queue: RequestQueue = Volley.newRequestQueue(this@crop_predictionActivity)
            queue.add(jsonObjectRequest)
        }




    }
}
