package com.anshuman.bharatagro.Activitys

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.anshuman.bharatagro.MainActivity

import com.anshuman.bharatagro.R
import com.anshuman.bharatagro.databinding.ActivityLoginpageBinding

class Loginpage : AppCompatActivity() {

    lateinit var binding: ActivityLoginpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnsinup.setOnClickListener {

            startActivity(Intent(this,SignUp::class.java))
        }





    }
}