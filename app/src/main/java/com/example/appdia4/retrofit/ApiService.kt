package com.example.appdia4.retrofit

import retrofit2.http.Body

interface ApiService {

    // POST request to the "/register" endpoint
    suspend fun register(@Body registerData: RegisterData): RegisterResponse

}
