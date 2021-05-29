package com.developer.moneylover.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.developer.moneylover.R
import com.developer.moneylover.data.localtransaction.TransactionDatabase
import com.developer.moneylover.data.localtransaction.TransactionEntity
import com.developer.moneylover.repository.TransactionRepository
import com.developer.moneylover.viewmodels.TransactionViewModel
import com.developer.moneylover.viewmodels.TransactionViewModelFactory
import kotlinx.android.synthetic.main.activity_show_transaction_details.*

class ShowTransactionDetails : AppCompatActivity() {

    private lateinit var viewModel: TransactionViewModel

    var id: Int? = null


    private val transactionDao by lazy {
        val roomDatabase = TransactionDatabase.getDatabase(this)
        roomDatabase.getTransactionDao()
    }
    private val repository by lazy {
        TransactionRepository(transactionDao)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_transaction_details)

        id = intent.getIntExtra("id", 0)


        val viewModelFactory = TransactionViewModelFactory(repository)

        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(TransactionViewModel::class.java)
        settingData()
        initListeners()

    }

    private fun settingData() {


        val amount = intent.getIntExtra("amount", 0)
        val category = intent.getStringExtra("cat")
        val note = intent.getStringExtra("note")
        val date = intent.getStringExtra("date")
        val wallet = intent.getStringExtra("wallet")
        val with = intent.getStringExtra("with")
        Glide.with(ivCategoryImageShow).load(intent.getStringExtra("image")).into(ivCategoryImageShow)

        tvDisplayAmount.text = amount.toString()
        tvDisplayCategory.text = category
        tvDisplayNotes.text = note
        tvDisplayDate.text = date
        tvDisplayWallet.text = wallet
        tvDisplayWith.text = with

    }

    private fun initListeners() {
        btnCloseDisplayTransaction.setOnClickListener {
            finish()
        }

        tvDelete.setOnClickListener {
            val transactionEntity = TransactionEntity(0, "", "", "", "", "","")
            transactionEntity.id = id
            viewModel.deleteTransaction(transactionEntity)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        tvEdit.setOnClickListener {
            val intent = Intent(this, EditTransactionActivity::class.java)
            intent.putExtra("identity", id)
            startActivity(intent)
            finish()
        }
    }
}