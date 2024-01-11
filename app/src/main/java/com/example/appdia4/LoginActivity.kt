package com.example.appdia4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appdia4.databinding.ActivityLoginBinding
import com.example.appdia4.helper.PreferenceHelper
import com.example.appdia4.transaction.TransactionViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var preferenceHelper: PreferenceHelper
    private lateinit var viewModel: TransactionViewModel

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

        // revision add implementation api login in -> TransactionViewModel
        viewModel.performLogin(username, password)
        viewModel.loginSuccess.observe(this) { success ->
            if (success) {

//        if (username == "andre" && password == "123") {
//            // Save user data in SharedPreferences using the helper
//            preferenceHelper.saveString(PreferenceHelper.KEY_USERNAME, username)
//            preferenceHelper.saveBoolean(PreferenceHelper.KEY_IS_LOGGED_IN, true)

//            // Navigate to the ProfileFragment
//            val fragment = ProfileFragment()
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.flFragment, fragment)
//                .commit()

                // revision intent to start fragment activity -> finish()
                val main = Intent(this@LoginActivity, FragmentActivity::class.java)
                startActivity(main)
            } else {
                // Handle login failure
            }
        }
    }

}