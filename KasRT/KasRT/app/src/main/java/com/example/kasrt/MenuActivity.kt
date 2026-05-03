package com.example.kasrt

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Inisialisasi ImageButton
        val imageButton0 = findViewById<ImageButton>(R.id.imageButton0)
        val imageButton1 = findViewById<ImageButton>(R.id.imageButton1)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton4)
        val imageButton5 = findViewById<ImageButton>(R.id.imageButton5)

        // Menambahkan listener klik ke setiap ImageButton
        imageButton0.setOnClickListener {
            val intent = Intent(this@MenuActivity, MainActivity::class.java)
            startActivity(intent)
        }

        imageButton1.setOnClickListener {
            // Tambahkan kode untuk menangani klik tombol di sini
        }

        imageButton2.setOnClickListener {
            // Tambahkan kode untuk menangani klik tombol di sini
        }

        imageButton3.setOnClickListener {
            // Tambahkan kode untuk menangani klik tombol di sini
        }

        imageButton4.setOnClickListener {
            // Tambahkan kode untuk menangani klik tombol di sini
        }

        imageButton5.setOnClickListener {
            // Tambahkan kode untuk menangani klik tombol di sini
        }
    }
}