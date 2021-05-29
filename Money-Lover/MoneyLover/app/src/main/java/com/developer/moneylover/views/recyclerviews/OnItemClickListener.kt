package com.developer.moneylover.views.recyclerviews

import com.developer.moneylover.data.localtransaction.TransactionEntity

interface OnItemClickListener {
    fun onItemClick(transactionEntity: TransactionEntity)
}