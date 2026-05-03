package com.example.kasrt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.model.Announcement

class AnnouncementAdapter(private var list: List<Announcement>) :
    RecyclerView.Adapter<AnnouncementAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val indicator: View = view.findViewById(R.id.indicatorType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_announcement, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.tvTitle.text = item.title
        holder.tvDate.text = item.date
        holder.tvDescription.text = item.description
        
        // Change indicator color based on type if needed
        // For now using default primary
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<Announcement>) {
        list = newList
        notifyDataSetChanged()
    }
}
