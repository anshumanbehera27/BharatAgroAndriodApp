package com.anshuman.bharatagro.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.anshuman.bharatagro.Activitys.Loginpage

import com.anshuman.bharatagro.Activitys.SignUp
import com.anshuman.bharatagro.R
import com.google.firebase.auth.FirebaseAuth

class profile_Fragment : Fragment() {
    // Make it dynamic
    private lateinit var editButton :Button
    private lateinit var auth :FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profile_, container, false)

        editButton = view.findViewById(R.id.editProfile)

        editButton.setOnClickListener{
            val intent = Intent(activity, SignUp::class.java)
            startActivity(intent)
            Toast.makeText(activity, "Edit Profile", Toast.LENGTH_LONG).show()
        }
        // how to Sign out the data from fire base
        auth = FirebaseAuth.getInstance()
        val signOutButton = view.findViewById<Button>(R.id.buttonsignout)
        signOutButton.setOnClickListener {
            auth.signOut()
            startActivity(Intent(activity, Loginpage::class.java))
            Toast.makeText(activity, "Sign Out Successfully", Toast.LENGTH_LONG).show()
        }

        return view
    }
}