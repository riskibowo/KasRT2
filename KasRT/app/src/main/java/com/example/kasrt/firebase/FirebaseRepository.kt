package com.example.kasrt.firebase

import com.example.kasrt.model.Announcement
import com.example.kasrt.model.DataItem
import com.google.firebase.database.*

class FirebaseRepository private constructor() {
    private val database: DatabaseReference = FirebaseDatabase.getInstance("https://kas-rt-app-2026-default-rtdb.asia-southeast1.firebasedatabase.app").reference

    companion object {
        @Volatile
        private var INSTANCE: FirebaseRepository? = null

        fun getInstance(): FirebaseRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = FirebaseRepository()
                INSTANCE = instance
                instance
            }
        }
    }

    fun getUsers(callback: (List<DataItem>?) -> Unit) {
        database.child("users").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val users = mutableListOf<DataItem>()
                for (child in snapshot.children) {
                    val user = child.getValue(DataItem::class.java)
                    if (user != null) {
                        users.add(user)
                    }
                }
                callback(users)
            }

            override fun onCancelled(error: DatabaseError) {
                callback(null)
            }
        })
    }

    fun getPemanfaatan(callback: (List<DataItem>?) -> Unit) {
        database.child("pemanfaatan").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = mutableListOf<DataItem>()
                for (child in snapshot.children) {
                    val item = child.getValue(DataItem::class.java)
                    if (item != null) {
                        data.add(item)
                    }
                }
                callback(data)
            }

            override fun onCancelled(error: DatabaseError) {
                callback(null)
            }
        })
    }

    fun getAnnouncements(callback: (List<Announcement>) -> Unit) {
        database.child("announcements").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<Announcement>()
                for (data in snapshot.children) {
                    val item = data.getValue(Announcement::class.java)
                    if (item != null) list.add(item)
                }
                callback(list)
            }
            override fun onCancelled(error: DatabaseError) {
                callback(emptyList())
            }
        })
    }

    fun getPengurus(callback: (List<com.example.kasrt.model.Pengurus>) -> Unit) {
        database.child("pengurus").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<com.example.kasrt.model.Pengurus>()
                for (data in snapshot.children) {
                    val item = data.getValue(com.example.kasrt.model.Pengurus::class.java)
                    if (item != null) list.add(item)
                }
                callback(list)
            }
            override fun onCancelled(error: DatabaseError) {
                callback(emptyList())
            }
        })
    }
}
