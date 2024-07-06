package com.anshuman.bharatagro.Activitys

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.bharatagro.R

class Deatils_InfoActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatils_info)
        val headingTextView = findViewById<TextView>(R.id.headingTextView)
        val paragraphTextView = findViewById<TextView>(R.id.paragraphTextView)
        val heading = intent.getStringExtra("heading") ?: ""
        val paragraph = intent.getStringExtra("paragraph") ?: ""
        headingTextView.text = heading
        paragraphTextView.text = paragraph
    }
}