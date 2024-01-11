package com.example.appdia4.transaction

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appdia4.helper.PreferenceHelper
import com.example.appdia4.login.ApiService
import com.example.appdia4.login.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// revisition added api
class TransactionViewModel : ViewModel() {

    private val repository = TransactionRepository()
    private lateinit var preferenceHelper: PreferenceHelper

    fun setPreferenceHelper(helper: PreferenceHelper) {
        preferenceHelper = helper
    }

    fun getTransactions(): LiveData<List<Transaction>> {
        return repository.getTransactions()
    }

    val loginSuccess = MutableLiveData<Boolean>()

    fun performLogin(username: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.4.174:4050/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val call = apiService.login(username, mapOf("user_password" to password))

        call.enqueue(object : Callback<LoginResponse> {
            @RequiresApi(Build.VERSION_CODES.P)
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    loginSuccess.value = loginResponse?.success ?: false

                    if (loginResponse?.success == true) {
                        val userName = loginResponse?.data?.id ?: ""
                        preferenceHelper.saveString(PreferenceHelper.KEY_USERNAME, userName)
                        preferenceHelper.saveBoolean(PreferenceHelper.KEY_IS_LOGGED_IN, true)
                    }
                } else {

                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }
        })
    }
}