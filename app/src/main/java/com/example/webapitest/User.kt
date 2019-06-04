package com.example.webapitest


data class User(
    val id: Long,
    val user_name: String,
    val password: String,
    val phone_number: Int,
    val address: String,
    val items: List<String>
)