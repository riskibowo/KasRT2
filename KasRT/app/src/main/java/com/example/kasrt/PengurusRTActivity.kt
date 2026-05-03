package com.example.kasrt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.firebase.FirebaseRepository

class PengurusRTActivity : AppCompatActivity() {

    private lateinit var rvPengurus: RecyclerView
    private lateinit var adapter: PengurusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengurus)

        rvPengurus = findViewById(R.id.rvPengurus)
        adapter = PengurusAdapter(emptyList())
        rvPengurus.layoutManager = LinearLayoutManager(this)
        rvPengurus.adapter = adapter

        fetchData()
    }

    private fun fetchData() {
        FirebaseRepository.getInstance().getPengurus { list ->
            runOnUiThread {
                adapter.updateData(list)
            }
        }
    }
}
