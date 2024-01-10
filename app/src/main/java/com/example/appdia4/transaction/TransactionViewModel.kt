package com.example.appdia4.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel() {

    private val repository = TransactionRepository()

    fun getTransactions(): LiveData<List<Transaction>> {
        return repository.getTransactions()
    }
}