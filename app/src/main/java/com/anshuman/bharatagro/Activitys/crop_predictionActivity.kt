package com.anshuman.bharatagro.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.bharatagro.R


import android.widget.TextView
import com.google.android.material.slider.Slider

class crop_predictionActivity : AppCompatActivity() {

    private lateinit var result: TextView
    private lateinit var slider: Slider
    private val suggestedValue = 50 // Example suggested value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop_prediction)

//        result = findViewById(R.id.result)
//        slider = findViewById(R.id.slider1)
//        slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
//            override fun onStartTrackingTouch(slider: Slider) {
//                // Optional: Do something when touch tracking starts
//            }
//
//            override fun onStopTrackingTouch(slider: Slider) {
//                // Store the final value and display it in the result TextView
//                val finalSliderValue = slider.value
//                result.text = String.format("Selected Slider: %.2f", finalSliderValue)
//            }
//        })
//
//        // Print the suggested value to the console
//        println("Suggested value for SeekBar: $suggestedValue")
//    }
    }
}
