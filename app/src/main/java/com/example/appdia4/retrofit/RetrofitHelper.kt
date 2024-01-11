package com.example.appdia4.retrofit

import com.example.appdia4.login.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    // Create a Retrofit instance with base URL and Gson converter
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:4050")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService: ApiService = retrofit.create(ApiService::class.java)
}


