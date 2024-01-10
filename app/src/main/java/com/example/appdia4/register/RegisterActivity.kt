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

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.btnRegister.setOnClickListener {
            val userName = binding.etUserName.text.toString()
            val userPhone = binding.etUserPhone.text.toString()
            val userEmail = binding.etUserEmail.text.toString()
            val userPassword = binding.etUserPassword.text.toString()

            val validation = RegisterValidation()
            if (validation.validatePhone(userPhone) && validation.validateEmail(userEmail) && validation.validatePassword(userPassword)) {
                viewModel.register(userName, userPhone, userEmail, userPassword)
            } else {
                Snackbar.make(binding.root, "Invalid input", Snackbar.LENGTH_LONG).show()
            }
        }

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