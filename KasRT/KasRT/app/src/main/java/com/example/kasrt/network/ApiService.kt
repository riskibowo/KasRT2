package com.example.kasrt.network

import android.telecom.Call
import com.example.kasrt.model.ResponseUser
import retrofit2.http.GET



interface ApiService {

    @GET("data")
    fun getUsers(): Call<ResponseUser>

    @GET("pemanfaatan")
    fun getPemanfaatan(): Call<ResponseUser>
}

