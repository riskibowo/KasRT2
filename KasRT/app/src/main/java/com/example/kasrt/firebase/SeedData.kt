package com.example.kasrt.firebase

import com.example.kasrt.model.DataItem
import com.google.firebase.database.FirebaseDatabase

object SeedData {
    fun uploadSampleData() {
        val database = FirebaseDatabase.getInstance("https://kas-rt-app-2026-default-rtdb.asia-southeast1.firebasedatabase.app").reference
        
        val users = listOf(
            DataItem("User", "1", "user1@gmail.com", "Blok A No. 1", 150000, 50000, "Lengkap", "https://randomuser.me/api/portraits/men/1.jpg"),
            DataItem("User", "2", "user2@gmail.com", "Blok B No. 2", 100000, 50000, "Lengkap", "https://randomuser.me/api/portraits/men/2.jpg"),
            DataItem("User", "3", "user3@gmail.com", "Blok C No. 3", 50000, 50000, "Menunggak", "https://randomuser.me/api/portraits/men/3.jpg"),
            DataItem("User", "4", "user4@gmail.com", "Blok D No. 4", 200000, 50000, "Lengkap", "https://randomuser.me/api/portraits/men/4.jpg"),
            DataItem("User", "5", "user5@gmail.com", "Blok E No. 5", 150000, 50000, "Lengkap", "https://randomuser.me/api/portraits/women/1.jpg")
        )

        val pemanfaatan = listOf(
            DataItem("User", "1", "user1@gmail.com", "Blok A No. 1", 150000, 50000, "Lengkap", "https://randomuser.me/api/portraits/men/1.jpg"),
            DataItem("User", "2", "user2@gmail.com", "Blok B No. 2", 100000, 50000, "Lengkap", "https://randomuser.me/api/portraits/men/2.jpg")
        )

        val announcements = listOf(
            com.example.kasrt.model.Announcement("Jadwal Kerja Bakti Mei", "Diharapkan kehadiran Bapak/Ibu pada hari Minggu, 12 Mei 2024 untuk membersihkan area taman dan selokan.", "08 Mei 2024", "warning"),
            com.example.kasrt.model.Announcement("Sosialisasi Keamanan Lingkungan", "Rapat warga akan diadakan pada hari Sabtu jam 20.00 di Balai RT untuk membahas sistem keamanan baru.", "07 Mei 2024", "info"),
            com.example.kasrt.model.Announcement("Laporan Kas Bulan April", "Laporan keuangan bulan April sudah dapat diakses melalui menu Laporan Kas. Saldo surplus.", "01 Mei 2024", "success")
        )

        val pengurus = listOf(
            com.example.kasrt.model.Pengurus("Bapak Ahmad Subarjo", "Ketua RT", "0812-3456-7890", "https://randomuser.me/api/portraits/men/10.jpg"),
            com.example.kasrt.model.Pengurus("Ibu Siti Aminah", "Sekretaris", "0812-9876-5432", "https://randomuser.me/api/portraits/women/10.jpg"),
            com.example.kasrt.model.Pengurus("Bapak Bambang Wijaya", "Bendahara", "0813-1111-2222", "https://randomuser.me/api/portraits/men/11.jpg")
        )

        users.forEachIndexed { index, dataItem ->
            database.child("users").child("user$index").setValue(dataItem)
        }

        pemanfaatan.forEachIndexed { index, dataItem ->
            database.child("pemanfaatan").child("item$index").setValue(dataItem)
        }

        announcements.forEachIndexed { index, ann ->
            database.child("announcements").child("ann$index").setValue(ann)
        }

        pengurus.forEachIndexed { index, p ->
            database.child("pengurus").child("p$index").setValue(p)
        }
    }
}
