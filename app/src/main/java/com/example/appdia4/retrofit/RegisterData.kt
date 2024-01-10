package com.example.appdia4.retrofit

data class RegisterData(
    val user_name: String,
    val user_phone: String,
    val user_email: String,
    val user_password: String,
    val user_pictures: String? = null
)