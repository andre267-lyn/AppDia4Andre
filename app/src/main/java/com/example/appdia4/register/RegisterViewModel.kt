package com.example.appdia4.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdia4.retrofit.RegisterResponse
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val registerRepository = RegisterRepository()
    private val _registerLiveData = MutableLiveData<RegisterResponse>()
    val registerLiveData: LiveData<RegisterResponse> = _registerLiveData

    fun register(userName: String, userPhone: String, userEmail: String, userPassword: String) {
        viewModelScope.launch {
            val result = registerRepository.register(userName, userPhone, userEmail, userPassword)
            _registerLiveData.value = result
        }
    }

}

