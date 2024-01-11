package com.example.appdia4.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdia4.retrofit.RegisterResponse
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    // Create an instance of the RegisterRepository to handle registration logic
    private val registerRepository = RegisterRepository()

    // MutableLiveData to hold RegisterResponse - This will be observed by the UI
    private val _registerLiveData = MutableLiveData<RegisterResponse>()
    val registerLiveData: LiveData<RegisterResponse> = _registerLiveData

    // Function to initiate the registration process
    fun register(userName: String, userPhone: String, userEmail: String, userPassword: String) {
        // Launch a coroutine within ViewModel's viewModelScope
        viewModelScope.launch {
            // Call the repository's 'register' method to perform registration asynchronously
            val result = registerRepository.register(userName, userPhone, userEmail, userPassword)
            // Update the MutableLiveData with the obtained result
            _registerLiveData.value = result
        }
    }
}
