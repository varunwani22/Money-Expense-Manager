package com.developer.moneylover.views

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.developer.moneylover.views.bottomnavigation.AddTransactionFragment

class DatePicker: DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val addTransactionFragment = AddTransactionFragment()
    }


}