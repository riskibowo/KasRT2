package com.example.kasrt.model

data class Announcement(
    val title: String = "",
    val description: String = "",
    val date: String = "",
    val type: String = "info" // info, warning, success
)
