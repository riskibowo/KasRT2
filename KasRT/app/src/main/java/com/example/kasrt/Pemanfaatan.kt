package com.example.kasrt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.model.DataItem
import java.text.NumberFormat
import java.util.Locale
class Pemanfaatan(private val pemanfaatan:MutableList<DataItem>) :
    RecyclerView.Adapter<Pemanfaatan.ListViewHolder>() {
    constructor() : this(mutableListOf())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pemanfaatan, parent, false)
        return ListViewHolder(view)
    }
    fun setPemanfaatan(dataItems: List<DataItem>) {
        pemanfaatan.clear()
        pemanfaatan.addAll(dataItems)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = pemanfaatan.size
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = pemanfaatan[position]
        val numberFormat = NumberFormat.getNumberInstance(Locale("id", "ID"))
        val formattedHarga = numberFormat.format(item.pengeluaran_iuran_warga)
        
        holder.tvPemanfaatan.text = item.pemanfaatan_iuran
        holder.tvHarga.text = "Rp $formattedHarga"
    }
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvPemanfaatan: TextView = itemView.findViewById(R.id.itemPemanfaatan)
        var tvHarga: TextView = itemView.findViewById(R.id.itemHarga)
    }
}