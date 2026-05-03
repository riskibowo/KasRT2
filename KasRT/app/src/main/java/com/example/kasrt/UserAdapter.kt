package com.example.kasrt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.kasrt.model.DataItem
import java.text.NumberFormat
import java.util.Locale

class UserAdapter(private val users: MutableList<DataItem>):
    RecyclerView.Adapter<UserAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent,false)
        return ListViewHolder(
            view
        )
    }

    fun setUsers(users: List<DataItem>) {
        this.users.clear()
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    fun addUser(newUser: DataItem?) {
        newUser?.let {
            users.add(it)
            notifyItemInserted(users.lastIndex)
        }
    }

    fun clear(){
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int){
        val user = users[position]

        val numberFormat = NumberFormat.getNumberInstance(Locale("id", "ID"))
        val formattedIuran = numberFormat.format(user.total_iuran_individu)

        Glide.with(holder.itemView.context)
            .load(user.gambar)
            .placeholder(R.drawable.icon_avatar)
            .error(R.drawable.icon_avatar)
            .into(holder.tvAvatar)
            
        holder.tvUserName.text = "${user.nama_depan} ${user.nama_belakang}"
        holder.tvEmail.text = user.email
        holder.tvAddress.text = user.alamat
        holder.tvTotalIuran.text = "Total Iuran: Rp $formattedIuran"
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvUserName: TextView = itemView.findViewById(R.id.itemName)
        var tvEmail: TextView = itemView.findViewById(R.id.itemEmail)
        var tvAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
        var tvAddress: TextView = itemView.findViewById(R.id.itemAddress)
        var tvTotalIuran: TextView = itemView.findViewById(R.id.itemTotalIuran) // Typo, diganti menjadi tvTotalIuran
    }
}
