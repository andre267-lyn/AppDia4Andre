package com.example.appdia4.login

import android.service.autofill.UserData

data class LoginResponse(
    val success: Boolean?,
    val message: String?,
    val errorCode: String?,
    val data: UserData?
)