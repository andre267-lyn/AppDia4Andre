package com.example.appdia4.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    // Create a Retrofit instance with base URL and Gson converter
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:4050")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Create an instance of ApiService using the Retrofit instance
    val apiService: ApiService = retrofit.create(ApiService::class.java)
}


