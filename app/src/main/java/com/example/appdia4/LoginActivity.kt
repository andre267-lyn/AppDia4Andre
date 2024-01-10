package com.example.appdia4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.appdia4.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            validateAndProceed()
        }
    }

    private fun validateAndProceed() {
        Log.d("FragmentActivity", "Validating credentials...")
        val username = binding.username.editText?.text.toString()
        val password = binding.password.editText?.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {

            if (isAuthorizedUser(username, password)) {

                val intent = Intent(this, FragmentActivity::class.java)
                startActivity(intent)
                finish()
            } else {

                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        } else {

            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAuthorizedUser(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()

    }
}