package com.anshuman.bharatagro.Activitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.anshuman.bharatagro.R
import com.anshuman.bharatagro.databinding.ActivityStartScreeenBinding

class StartScreeen : AppCompatActivity() {
// TODO 2 crete the Start screen With lotify annimation
    lateinit var binding: ActivityStartScreeenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartScreeenBinding.inflate(layoutInflater)

        setContentView(binding.root)
        // Move  to the Login page  Page
        binding.btngetstarted.setOnClickListener{
            startActivity(Intent(this,Loginpage::class.java))
        }
    }
}