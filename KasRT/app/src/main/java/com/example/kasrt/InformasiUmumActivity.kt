package com.example.kasrt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.firebase.FirebaseRepository

class InformasiUmumActivity : AppCompatActivity() {
    private lateinit var rvAnnouncements: RecyclerView
    private lateinit var adapter: AnnouncementAdapter
    private val repository = FirebaseRepository.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announcement)

        rvAnnouncements = findViewById(R.id.rvAnnouncements)
        rvAnnouncements.layoutManager = LinearLayoutManager(this)
        
        adapter = AnnouncementAdapter(emptyList())
        rvAnnouncements.adapter = adapter

        loadData()
    }

    private fun loadData() {
        repository.getAnnouncements { list ->
            adapter.updateData(list)
        }
    }
}
