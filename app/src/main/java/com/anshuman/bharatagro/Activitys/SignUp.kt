package com.anshuman.bharatagro.Activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.bharatagro.HomeActivity
import com.anshuman.bharatagro.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        // redrict to the Home page
        binding.btnsinup.setOnClickListener{

            val email = binding.etEmail.text.toString()
            val password = binding.etpassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email , password)
                    .addOnCompleteListener(this){task ->

                    if (task.isSuccessful){
                        Toast.makeText(this , "Sign Up Successfully" , Toast.LENGTH_SHORT).show()
                        // redrict to the Home page
                        startActivity(Intent(this ,HomeActivity::class.java))
                        finish()
                    }

                        else{
                            // Toast.makeText(this , "Sign up is not successful" , Toast.LENGTH_SHORT).show()
                            Toast.makeText(this , task.exception.toString() , Toast.LENGTH_SHORT).show()

                        }
                    }
            }else{
              if (email.isEmpty()){
                  Toast.makeText(this , "Enter Your email" , Toast.LENGTH_SHORT).show()

              }
                else{
                  Toast.makeText(this , "Enter password" , Toast.LENGTH_SHORT).show()

              }
            }

           // startActivity(Intent(this ,HomeActivity::class.java))
        }
        // redrict to the main page
        binding.btnlogin.setOnClickListener{
            startActivity(Intent(this , Loginpage::class.java))
        }
    }
}