package com.anshuman.bharatagro.Activitys

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.bharatagro.R

class SplashScreen : AppCompatActivity() {

    private val splashDuration: Long = 3000 // 3seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // TODO 1 redrict to the start screen with 3 sec automatically
        // Handler to delay the launch of the MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Start MainActivity
            val intent = Intent(this, StartScreeen::class.java)
            startActivity(intent)
            // Close SplashActivity
            finish()
        }, splashDuration)
    }
}