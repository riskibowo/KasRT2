package com.example.kasrt

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.firebase.FirebaseRepository
import java.text.NumberFormat
import java.util.Locale

class LaporanActivity : AppCompatActivity() {

    private lateinit var adapter: Pemanfaatan
    private lateinit var rv_laporan: RecyclerView
    private lateinit var jumlahIuranBulananTextView: TextView
    private lateinit var totalIuranTextView: TextView
    private lateinit var pengeluaranTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        rv_laporan = findViewById(R.id.rv_laporan)
        jumlahIuranBulananTextView = findViewById(R.id.jumlahIuranBulananTextView)
        totalIuranTextView = findViewById(R.id.totalIuranTextView)
        pengeluaranTextView = findViewById(R.id.pengeluaranTextView)

        adapter = Pemanfaatan(mutableListOf())

        rv_laporan.layoutManager = LinearLayoutManager(this)
        rv_laporan.adapter = adapter

        getPemanfaatan()
    }

    private fun getPemanfaatan() {
        val repository = com.example.kasrt.firebase.FirebaseRepository.getInstance()
        repository.getPemanfaatan { dataArray ->
            if (dataArray != null) {
                var totalIuranBulanan = 0
                for (dataItem in dataArray) {
                    totalIuranBulanan += dataItem.total_iuran_individu
                }
                var totalPengeluaran = 0
                for (dataItem in dataArray) {
                    totalPengeluaran += dataItem.pengeluaran_iuran_warga
                }
                var rekapIuran = totalIuranBulanan - totalPengeluaran
                val numberFormat = NumberFormat.getNumberInstance(Locale("id", "ID"))
                val formattedIuranBulanan = numberFormat.format(totalIuranBulanan)
                val formattedPengeluaran = numberFormat.format(totalPengeluaran)
                val formattedRekap = numberFormat.format(rekapIuran)

                jumlahIuranBulananTextView.text = "Rp $formattedIuranBulanan"
                pengeluaranTextView.text = "Rp $formattedPengeluaran"
                totalIuranTextView.text = "Saldo Total: Rp $formattedRekap"

                // Set data pemanfaatan pada adapter
                adapter.setPemanfaatan(dataArray)
            } else {
                Toast.makeText(this@LaporanActivity, "Failed to retrieve data from Firebase", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
