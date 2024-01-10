package com.example.appdia4.transaction

data class Transaction(
    val idTransaction: Int,
    val amount: Int,
    val senderName: String,
    val receiverName: String,
    val status: String,
    val date: String,
    val type: String
)
