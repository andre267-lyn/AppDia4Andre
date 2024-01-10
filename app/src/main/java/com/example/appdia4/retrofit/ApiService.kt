package com.example.appdia4.retrofit

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/register")
    suspend fun register(@Body registerData: RegisterData): RegisterResponse

}
