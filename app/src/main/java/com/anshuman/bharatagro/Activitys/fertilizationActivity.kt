package com.anshuman.bharatagro.Activitys


import com.android.volley.DefaultRetryPolicy
import com.android.volley.RequestQueue
import com.android.volley.RetryPolicy
import okhttp3.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.anshuman.bharatagro.databinding.ActivityFertilizationBinding
import com.google.android.material.slider.Slider
import org.json.JSONException
import org.json.JSONObject

class fertilizationActivity : AppCompatActivity() {
    lateinit var binding: ActivityFertilizationBinding
    val url = "https://agro-api-xnfo.onrender.com/predictfertilizer"
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFertilizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSliders()
        binding.btnFertPrediction.setOnClickListener {
            val data = getEnteredData()
            sendRequest(data)
        }
    }

    private fun setupSliders() {
        binding.sliderTemperature.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                val finalSliderValue = slider.value
                binding.tvresultTemperature.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })

        binding.sliderHumidity.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                val finalSliderValue = slider.value
                binding.tvresultHumidity.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })

        binding.sliderSoilMoisture.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                val finalSliderValue = slider.value
                binding.tvresultSoilMoisture.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })

        binding.sliderNitrogen.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                val finalSliderValue = slider.value
                binding.tvresultNitrogen.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })

        binding.sliderPhosphorous.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                val finalSliderValue = slider.value
                binding.tvresultPhosphorous.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })

        binding.sliderPotassium.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Optional: Do something when touch tracking starts
            }

            override fun onStopTrackingTouch(slider: Slider) {
                val finalSliderValue = slider.value
                binding.tvresultPotassium.text =
                    String.format("Selected Slider: %.2f", finalSliderValue)
            }
        })
    }


    private fun getEnteredData(): Map<String, Any> {
        val data = mutableMapOf<String, Any>()

        // Ensure Temperature is correctly added
        val temperatureValue = binding.sliderTemperature.value
        if (temperatureValue != null) {
            data["Temperature"] = temperatureValue
        } else {
            // Handle case where Temperature is not available or valid
            binding.tvPredictResult.text = "Temperature value is missing."
            return emptyMap() // Return an empty map to prevent sending an incomplete request
        }

        data["Humidity"] = binding.sliderHumidity.value
        data["SoilMoisture"] = binding.sliderSoilMoisture.value
        data["soil_type"] = binding.editTextSoilType.text.toString()
        data["crop_type"] = binding.editTextCropType.text.toString()
        data["Nitrogen"] = binding.sliderNitrogen.value
        data["Phosphorus"] = binding.sliderPhosphorous.value
        data["Potassium"] = binding.sliderPotassium.value

        return data
    }

    private fun sendRequest(data: Map<String, Any>) {
        if (data.isEmpty()) {
            // If data is empty, don't proceed with the request
            binding.tvPredictResult.text = "Cannot send request, missing required fields."
            return
        }

        val json = JSONObject(data)
        val requestBody = json.toString()

        runOnUiThread {
            binding.tvPredictResult.text = "Sending data: $requestBody"
        }

        val jsonObjectRequest = object : JsonObjectRequest(
            Method.POST, url, json,
            Response.Listener { response ->
                try {
                    val predictionResult = response.getString("predictfertilizer")
                    binding.tvPredictResult.text = predictionResult
                } catch (e: JSONException) {
                    e.printStackTrace()
                    binding.tvPredictResult.text = e.message
                }
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
                val response = error.networkResponse
                if (response != null && response.data != null) {
                    val errorResponse = String(response.data)
                    println("Error Response: $errorResponse")
                    binding.tvPredictResult.text = errorResponse
                } else {
                    binding.tvPredictResult.text = error.message
                }
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                return headers
            }
        }

        val socketTimeout = 30000  // 30 seconds. You can change this value as needed.
        val retryPolicy: RetryPolicy = DefaultRetryPolicy(
            socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        jsonObjectRequest.retryPolicy = retryPolicy

        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(jsonObjectRequest)
    }
}

