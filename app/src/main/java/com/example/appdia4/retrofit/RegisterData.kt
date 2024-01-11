package com.example.appdia4.retrofit

// Data class representing the payload to be sent for user registration
data class RegisterData(
    val user_name: String,
    val user_phone: String,
    val user_email: String,
    val user_password: String,
    val user_pictures: String? = null
)