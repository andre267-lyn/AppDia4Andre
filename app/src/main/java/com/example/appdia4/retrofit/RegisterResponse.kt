package com.example.appdia4.retrofit

// Data class representing the response obtained after user registration
data class RegisterResponse(
    val success: Boolean,
    val message: String,
    val errorCode: String?,
    val data: String?
)
