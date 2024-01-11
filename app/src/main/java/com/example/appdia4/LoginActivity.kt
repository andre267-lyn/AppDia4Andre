package com.example.appdia4

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appdia4.databinding.ActivityLoginBinding
import com.example.appdia4.fragment.ProfileFragment
import com.example.appdia4.helper.PreferenceHelper

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceHelper = PreferenceHelper(this)

        val loginButton: Button = findViewById(R.id.loginBtn)
        loginButton.setOnClickListener {
            performLogin()
        }
    }

    private fun performLogin() {
        val username = binding.username.editText?.text.toString()
        val password = binding.password.editText?.text.toString()

        if (username == "andre" && password == "123") {
            // Save user data in SharedPreferences using the helper
            preferenceHelper.saveString(PreferenceHelper.KEY_USERNAME, username)
            preferenceHelper.saveBoolean(PreferenceHelper.KEY_IS_LOGGED_IN, true)

            // Navigate to the ProfileFragment
            val fragment = ProfileFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()
        } else {
            // Handle login failure
        }
    }
}