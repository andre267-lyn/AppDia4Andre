package com.example.appdia4.login

import com.example.appdia4.retrofit.RegisterData
import com.example.appdia4.retrofit.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("/login")
    fun login(
        @Field("user_name") username: String,
        @Field("user_password") password: String
    ): Call<LoginResponse>

    @POST("/register")
    suspend fun register(@Body registerData: RegisterData): RegisterResponse
    abstract fun login(username: String, password: Map<String, String>): Call<LoginResponse>
}