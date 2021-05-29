package com.developer.moneylover.views

import android.app.Application
import com.developer.moneylover.data.localtransaction.TransactionDatabase
import com.developer.moneylover.repository.TransactionRepository

class TransactionApplication : Application() {

    private val transactionDao by lazy {
        val roomDatabase = TransactionDatabase.getDatabase(this)
        roomDatabase.getTransactionDao()
    }
    val repository by lazy {
        TransactionRepository(transactionDao)
    }
}