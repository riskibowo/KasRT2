package com.example.kasrt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class KegiatanRTActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placeholder)
        findViewById<TextView>(R.id.tv_title).text = "Kegiatan RT"
    }
}
