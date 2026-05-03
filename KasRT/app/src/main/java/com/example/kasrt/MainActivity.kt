package com.example.kasrt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.firebase.FirebaseRepository

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var rv_users: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Memaksa inisialisasi Firebase dengan URL yang benar (Asia Southeast)
        try {
            val options = com.google.firebase.FirebaseOptions.Builder()
                .setApplicationId("1:818618997545:android:c5ff3f8da34b3abbf17538") // Diambil dari google-services.json Anda
                .setApiKey("AIzaSyD-iIKAuGzgebY0hkCAMW953V-wfF8keNc")
                .setDatabaseUrl("https://kas-rt-app-2026-default-rtdb.asia-southeast1.firebasedatabase.app")
                .setProjectId("kas-rt-app-2026")
                .setStorageBucket("kas-rt-app-2026.firebasestorage.app")
                .build()
            
            if (com.google.firebase.FirebaseApp.getApps(this).isEmpty()) {
                com.google.firebase.FirebaseApp.initializeApp(this, options)
            }
        } catch (e: Exception) {
            android.util.Log.e("MainActivity", "Firebase init error: ${e.message}")
        }

        setContentView(R.layout.activity_main)

        rv_users = findViewById(R.id.rv_users)
        adapter = UserAdapter(mutableListOf())

        rv_users.layoutManager = LinearLayoutManager(this)
        rv_users.adapter = adapter

        getUser()
    }

    private fun getUser() {
        val repository = com.example.kasrt.firebase.FirebaseRepository.getInstance()
        repository.getUsers { users ->
            if (users != null) {
                if (users.isEmpty()) {
                    // Jika data kosong di Firebase, isi dengan data contoh
                    android.util.Log.d("MainActivity", "Data kosong, mengisi data contoh...")
                    com.example.kasrt.firebase.SeedData.uploadSampleData()
                    // Tunggu sebentar lalu coba ambil lagi
                    rv_users.postDelayed({ getUser() }, 2000)
                } else {
                    android.util.Log.d("MainActivity", "Data berhasil dimuat: ${users.size} orang")
                    adapter.setUsers(users)
                }
            } else {
                android.util.Log.e("MainActivity", "Gagal mengambil data dari Firebase")
                Toast.makeText(this@MainActivity, "Gagal mengambil data dari Firebase", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
