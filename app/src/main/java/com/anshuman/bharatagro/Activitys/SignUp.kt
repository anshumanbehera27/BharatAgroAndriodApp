package com.anshuman.bharatagro.Activitys

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.bharatagro.MainActivity
import com.anshuman.bharatagro.R
import com.anshuman.bharatagro.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // redrict to the Home page
        binding.btnsinup.setOnClickListener{
            startActivity(Intent(this ,MainActivity::class.java))
        }
        // redrict to the main page
        binding.btnlogin.setOnClickListener{
            startActivity(Intent(this , Loginpage::class.java))
        }


    }
}