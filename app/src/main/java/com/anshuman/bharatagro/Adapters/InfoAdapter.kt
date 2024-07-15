package com.anshuman.bharatagro.Adapters

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anshuman.bharatagro.Model.RetrieveData
import com.anshuman.bharatagro.R

import com.bumptech.glide.Glide

class InfoAdapter(private val context: Context, private val dataList: ArrayList<RetrieveData>) :
    RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {
    // Define interface for item click handling
    interface OnItemClickListener {
        fun onItemClick(item: RetrieveData)
    }
    // Listener variable
    private var listener: OnItemClickListener? = null

    // Method to set click listener
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.info_recycle, parent, false)
        return InfoViewHolder(view)
    }
    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val currentItem = dataList[position]

        Glide.with(context)
            .load(currentItem.imageURL)
            .into(holder.recyclerImage)

        holder.recyclerCaption.text = currentItem.caption

        // Set click listener on itemView
        holder.itemView.setOnClickListener {
            listener?.onItemClick(currentItem)
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    inner class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerImage: ImageView = itemView.findViewById(R.id.recyclerImage)
        val recyclerCaption: TextView = itemView.findViewById(R.id.recyclerCaption)
    }
}
