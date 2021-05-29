package com.developer.moneylover.views.bottomnavigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.developer.moneylover.R
import com.developer.moneylover.data.localtransaction.TransactionDatabase
import com.developer.moneylover.data.localtransaction.TransactionEntity
import com.developer.moneylover.repository.TransactionRepository
import com.developer.moneylover.viewmodels.TransactionViewModel
import com.developer.moneylover.viewmodels.TransactionViewModelFactory
import com.developer.moneylover.views.ShowTransactionDetails
import com.developer.moneylover.views.recyclerviews.OnItemClickListener
import com.developer.moneylover.views.recyclerviews.TransactionAdapter
import kotlinx.android.synthetic.main.fragment_transaction.*

class TransactionFragment : Fragment(), OnItemClickListener {

    private lateinit var viewModel: TransactionViewModel
    lateinit var transactionAdapter: TransactionAdapter
    private val transactionDao by lazy {
        val roomDatabase = TransactionDatabase.getDatabase(requireContext())
        roomDatabase.getTransactionDao()
    }
    val repository by lazy {
        TransactionRepository(transactionDao)
    }
    var transactionList = mutableListOf<TransactionEntity>()

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
        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerData()

        val viewModelFactory = TransactionViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(TransactionViewModel::class.java)

        viewModel.getTransaction().observe(viewLifecycleOwner, Observer {
            transactionList.clear()
            transactionList.addAll(it)
            transactionAdapter.notifyDataSetChanged()
        })


    }



    private fun setRecyclerData() {
        transactionAdapter = TransactionAdapter(transactionList, this)
        transactionRecyclerView.layoutManager = LinearLayoutManager(context)
        transactionRecyclerView.adapter = transactionAdapter
    }

    override fun onItemClick(transactionEntity: TransactionEntity) {
        val intent = Intent(context, ShowTransactionDetails::class.java)
        intent.putExtra("id", transactionEntity.id)
        intent.putExtra("amount", transactionEntity.amount)
        intent.putExtra("cat", transactionEntity.category)
        intent.putExtra("note", transactionEntity.note)
        intent.putExtra("date", transactionEntity.date)
        intent.putExtra("wallet", transactionEntity.wallet)
        intent.putExtra("with", transactionEntity.with)
        intent.putExtra("image",transactionEntity.image)
        startActivity(intent)
    }

}