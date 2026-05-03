package com.example.kasrt.model

import com.google.gson.annotations.SerializedName

data class ResponseUser(
    @SerializedName("data") val users: List<DataItem>

)
