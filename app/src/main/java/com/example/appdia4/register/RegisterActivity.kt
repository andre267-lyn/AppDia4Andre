package com.example.appdia4.register


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.appdia4.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar
//import com.example.appdia4.utils.Resource

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // prepare the view model
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        // click registration button
        binding.btnRegister.setOnClickListener {
            val userName = binding.etUserName.text.toString()
            val userPhone = binding.etUserPhone.text.toString()
            val userEmail = binding.etUserEmail.text.toString()
            val userPassword = binding.etUserPassword.text.toString()

            // validation input

            val validation = RegisterValidation()
            if (validation.validatePhone(userPhone) && validation.validateEmail(userEmail) && validation.validatePassword(userPassword)) {
                //call methode register from view model
                viewModel.register(userName, userPhone, userEmail, userPassword)
            } else {
                // message using snackbar if invalid
                Snackbar.make(binding.root, "Invalid input", Snackbar.LENGTH_LONG).show()
            }
        }

        //Livedata ouput registration
        viewModel.registerLiveData.observe(this) { result ->
            if (result.success) {
                // Registration successful
                Snackbar.make(binding.root, "Registration successful", Snackbar.LENGTH_LONG).show()
            } else {
                // Registration failed
                Snackbar.make(binding.root, result.message, Snackbar.LENGTH_LONG).show()
            }
        }
    }

}