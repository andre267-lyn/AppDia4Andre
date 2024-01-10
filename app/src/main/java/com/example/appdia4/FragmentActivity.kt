package com.example.appdia4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.appdia4.databinding.ActivityFragmentBinding
import com.example.appdia4.databinding.ActivityMainBinding
import com.example.appdia4.fragment.HomeFragment
import com.example.appdia4.fragment.ProfileFragment
import com.example.appdia4.fragment.TransactionFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding
    private val homeFragment = HomeFragment()
    private val transactionFragment = TransactionFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> replaceFragment(homeFragment)
                R.id.menu_transaction -> replaceFragment(transactionFragment)
                R.id.menu_profile -> replaceFragment(profileFragment)
                else -> false
            }
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flFragment, homeFragment)
                .commit()
        }
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, fragment)
            .commit()
        return true
    }
}