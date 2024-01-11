package com.example.appdia4.register

import com.example.appdia4.retrofit.RegisterData
import com.example.appdia4.retrofit.RegisterResponse
import com.example.appdia4.retrofit.RetrofitHelper
import retrofit2.HttpException

class RegisterRepository {

    suspend fun register(
        userName: String,
        userPhone: String,
        userEmail: String,
        userPassword: String
    ): RegisterResponse {
        val registerData = RegisterData(userName, userPhone, userEmail, userPassword)

        return try {
            val response = RetrofitHelper.apiService.register(registerData)

            if (!response.success) {
                val errorMessage = response.message ?: "Registration failed"
                val errorCode = response.errorCode ?: "Unknown error"
                RegisterResponse(success = false, message = errorMessage, errorCode = errorCode, data = null)
            } else {
                response
            }
        } catch (e: HttpException) {
            // Handle HTTP-related exceptions
            RegisterResponse(success = false, message = "Registration failed: ${e.message}", errorCode = e.code().toString(), data = null)
        } catch (e: Exception) {
            // Handle other exceptions
            RegisterResponse(success = false, message = "Registration failed: ${e.message}", errorCode = null, data = null)
        }
    }
}