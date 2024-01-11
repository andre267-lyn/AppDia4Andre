package com.example.appdia4.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(val context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String): String {
        return prefs.getString(key, defaultValue) ?: defaultValue
    }

    fun saveBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    fun clearPreferences() {
        prefs.edit().clear().apply()
    }

    companion object {
        private const val PREFS_NAME = "MyPrefs"
        const val KEY_USERNAME = "username"
        const val KEY_IS_LOGGED_IN = "isLoggedIn"
    }
}
