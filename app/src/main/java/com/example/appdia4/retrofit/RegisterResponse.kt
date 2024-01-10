package com.example.appdia4.retrofit

data class RegisterResponse(
    val success: Boolean,
    val message: String,
    val errorCode: String?,
    val data: Any?
)
