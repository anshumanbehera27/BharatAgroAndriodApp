package com.anshuman.bharatagro

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.anshuman.bharatagro.fragments.chat_Fragment
import com.anshuman.bharatagro.fragments.home_fragments
import com.anshuman.bharatagro.fragments.info_Fragment
import com.anshuman.bharatagro.fragments.profile_Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


/*
 How to Define the Bottom Navigation
  todo 1  Link with the Bottom navigation view
  todo 2 - how the all the Fragemet will replace
  todo 3 - set on item select listiner
  todo 4 - define the defult fragement
 */

class HomeActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bootom_home -> {
                    replaceFragment(home_fragments())
                    true
                }
                R.id.bootom_info ->{
                    replaceFragment(info_Fragment())
                    true
                }
                R.id.bootom_chat ->{
                    replaceFragment(chat_Fragment())
                    true
                }
                R.id.bootom_profile->{
                    replaceFragment(profile_Fragment())
                    true
                }
                else -> false
            }

        }
        replaceFragment(home_fragments())


    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

}