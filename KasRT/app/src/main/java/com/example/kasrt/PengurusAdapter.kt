package com.example.kasrt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kasrt.model.Pengurus
import com.google.android.material.imageview.ShapeableImageView

class PengurusAdapter(private var list: List<Pengurus>) : RecyclerView.Adapter<PengurusAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ShapeableImageView = view.findViewById(R.id.ivPhoto)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvPosition: TextView = view.findViewById(R.id.tvPosition)
        val tvPhone: TextView = view.findViewById(R.id.tvPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pengurus, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.tvName.text = item.name
        holder.tvPosition.text = item.position
        holder.tvPhone.text = item.phone

        Glide.with(holder.itemView.context)
            .load(item.image)
            .placeholder(android.R.color.darker_gray)
            .into(holder.ivPhoto)
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<Pengurus>) {
        list = newList
        notifyDataSetChanged()
    }
}
