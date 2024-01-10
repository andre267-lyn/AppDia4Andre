package com.example.appdia4.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData

class TransactionRepository {

    fun getTransactions(): LiveData<List<Transaction>> {
        return liveData {
            val transactions = mutableListOf<Transaction>()

            emit(transactions)
        }
    }
}
