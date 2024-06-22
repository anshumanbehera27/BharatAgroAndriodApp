package com.anshuman.bharatagro.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anshuman.bharatagro.Model.Crops
import com.anshuman.bharatagro.R

class CropAdapter(private val crops: List<Crops>) : RecyclerView.Adapter<CropAdapter.CropViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CropViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crop_item, parent, false)
        return CropViewHolder(view)
    }

    override fun onBindViewHolder(holder: CropViewHolder, position: Int) {
        val crop = crops[position]
        holder.imageView.setImageResource(crop.image)
        holder.textView.text = crop.title
    }
    override fun getItemCount(): Int {
        return crops.size
    }

    class CropViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}
