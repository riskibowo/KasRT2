package com.example.kasrt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Inisialisasi Menu Buttons (LinearLayout)
        val menuWarga = findViewById<LinearLayout>(R.id.btnWarga)
        val menuInformasi = findViewById<LinearLayout>(R.id.btnInformasi)
        val menuLaporan = findViewById<LinearLayout>(R.id.btnLaporan)
        val menuKegiatan = findViewById<LinearLayout>(R.id.btnKegiatan)

        // Menambahkan listener klik
        menuWarga.setOnClickListener {
            val intent = Intent(this@MenuActivity, MainActivity::class.java)
            startActivity(intent)
        }

        menuInformasi.setOnClickListener {
            val intent = Intent(this@MenuActivity, InformasiUmumActivity::class.java)
            startActivity(intent)
        }

        menuLaporan.setOnClickListener {
            val intent = Intent(this@MenuActivity, LaporanActivity::class.java)
            startActivity(intent)
        }

        menuKegiatan.setOnClickListener {
            val intent = Intent(this@MenuActivity, PengurusRTActivity::class.java)
            startActivity(intent)
        }
    }
}
