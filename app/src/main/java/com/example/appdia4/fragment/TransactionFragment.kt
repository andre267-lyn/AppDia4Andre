package com.example.appdia4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdia4.databinding.FragmentTransactionBinding
import com.example.appdia4.transaction.TransactionAdapter
import com.example.appdia4.transaction.TransactionViewModel

class TransactionFragment : Fragment() {

    private val viewModel : TransactionViewModel by viewModels()
    private lateinit var rvTransactions: RecyclerView
    private lateinit var adapter: TransactionAdapter
    private lateinit var binding : FragmentTransactionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // revisition this is only for set binding
        binding = FragmentTransactionBinding.inflate(inflater, container, false)
//        val root = inflater.inflate(R.layout.fragment_transaction, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // revition add set in here rv n adapter
        binding.rvTransactions.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }

//        viewModel = ViewModelProvider(this)[TransactionViewModel::class.java]

        viewModel.getTransactions().observe(viewLifecycleOwner) {
            // revision added transaction adapter
            adapter = TransactionAdapter()
            adapter.setData(it)
        }
    }
}