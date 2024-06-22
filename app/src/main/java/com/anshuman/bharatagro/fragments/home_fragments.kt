package com.anshuman.bharatagro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anshuman.bharatagro.Adapters.CropAdapter
import com.anshuman.bharatagro.Model.Crops
import com.anshuman.bharatagro.R

class home_fragments : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cropAdapter: CropAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.home_fragments, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_story)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        // Initialize CropAdapter and set it to the RecyclerView
        val crops = listOf(
            Crops(R.drawable.rice, "Rice"),
            Crops(R.drawable.wheat, "Wheat"),
            Crops(R.drawable.sugarcane, "Sugarcane"),
            Crops(R.drawable.rice, "Rice"),
            Crops(R.drawable.wheat, "Wheat"),
            Crops(R.drawable.sugarcane, "Sugarcane")

        )
        // Initialize CropAdapter  which will be used to populate the RecyclerView
        cropAdapter = CropAdapter(crops)
        recyclerView.adapter = cropAdapter

        // Set up the Toolbar
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_home -> {
                Toast.makeText(activity, "Home", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_info -> {
                Toast.makeText(activity, "Info", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_weather -> {
                Toast.makeText(activity, "Weather", Toast.LENGTH_LONG).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


}
