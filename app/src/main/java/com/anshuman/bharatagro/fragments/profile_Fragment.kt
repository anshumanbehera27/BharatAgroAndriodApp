package com.anshuman.bharatagro.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.anshuman.bharatagro.Activitys.SignUp
import com.anshuman.bharatagro.R

class profile_Fragment : Fragment() {
    // Make it dynamic
    private lateinit var editButton :Button
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
        return view
    }
}