package com.anshuman.bharatagro.Activitys

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.bharatagro.R
import com.anshuman.bharatagro.databinding.ActivitySoilreportsCenterBinding

class SoilreportsCenter : AppCompatActivity() {
    private lateinit var binding: ActivitySoilreportsCenterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoilreportsCenterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // WebView settings
        binding.webview.apply {
            webViewClient = WebViewClient() // Ensure the WebView stays within the app
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW // Optional, for mixed content
        }


        // Load the URL
        binding.webview.loadUrl("https://soilhealth.dac.gov.in/soil-lab")
    }
}
