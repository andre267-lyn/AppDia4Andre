package com.example.appdia4.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.appdia4.R
import com.example.appdia4.transaction.TransactionAdapter
import com.example.appdia4.transaction.TransactionViewModel

class TransactionFragment : Fragment() {

    private lateinit var viewModel: TransactionViewModel
    private lateinit var rvTransactions: RecyclerView
    private lateinit var adapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_transaction, container, false)

        viewModel = ViewModelProvider(this)[TransactionViewModel::class.java]


        viewModel.getTransactions().observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        return root
    }
}