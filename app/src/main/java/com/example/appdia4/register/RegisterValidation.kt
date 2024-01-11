package com.example.appdia4.register

class RegisterValidation {

    // Validates a phone number based on a specified regex pattern
    fun validatePhone(phone: String): Boolean {
        val pattern = Regex("^(\\+\\d{1,3}[- ]?)?\\d{10}$")
        return pattern.matches(phone)
    }

    // Validates an email address using a specific regex pattern
    fun validateEmail(email: String): Boolean {
        val pattern = Regex("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")
        return pattern.matches(email)
    }

    // Validates a password based on defined criteria using regex pattern matching
    fun validatePassword(password: String): Boolean {
        val pattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
        return pattern.matches(password)
    }

}