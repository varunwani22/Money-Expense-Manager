package com.developer.moneylover.views.recyclerviews

import com.developer.moneylover.data.localtransaction.TransactionEntity

interface ItemClickOperation {
    fun onEditListener(transactionEntity: TransactionEntity)
    fun onDeleteListener(transactionEntity: TransactionEntity)
}