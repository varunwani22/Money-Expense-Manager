package com.developer.moneylover.views.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.developer.moneylover.R
import com.developer.moneylover.data.localtransaction.TransactionDatabase
import com.developer.moneylover.repository.TransactionRepository
import com.developer.moneylover.viewmodels.TransactionViewModel
import com.developer.moneylover.viewmodels.TransactionViewModelFactory
import kotlinx.android.synthetic.main.fragment_today.*


class ReportFragment : Fragment() {
    private lateinit var viewModel: TransactionViewModel
    private val transactionDao by lazy {
        val roomDatabase = TransactionDatabase.getDatabase(requireContext())
        roomDatabase.getTransactionDao()
    }
    val repository by lazy {
        TransactionRepository(transactionDao)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory = TransactionViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(TransactionViewModel::class.java)

        viewModel.getTransaction().observe(viewLifecycleOwner, Observer {
        tvOpenAmountToday.text=it[0].amount.toString()
        })

    }
}