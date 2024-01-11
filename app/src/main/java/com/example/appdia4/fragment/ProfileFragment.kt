package com.example.appdia4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appdia4.databinding.FragmentProfileBinding
import com.example.appdia4.helper.PreferenceHelper


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        // instance to object preference helper
        preferenceHelper = PreferenceHelper(requireContext())

        // Load user data from SharedPreferences using helper
        val username = preferenceHelper.getString(PreferenceHelper.KEY_USERNAME, "")

        binding.usernameTextView.text = "welcome, $username!"

        return binding.root
    }
}

