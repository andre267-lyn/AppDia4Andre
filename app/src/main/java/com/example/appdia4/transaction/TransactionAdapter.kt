package com.example.appdia4.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdia4.databinding.ItemTransactionBinding

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    private var data: List<Transaction> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = data[position]
        holder.bind(transaction)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(newData: List<Transaction>) {
        data = newData
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            binding.apply {
                tvId.text = transaction.idTransaction.toString()
                tvAmount.text = transaction.amount.toString()
                tvSenderName.text = transaction.senderName
                tvReceiverName.text = transaction.receiverName
                tvStatus.text = transaction.status
                tvDate.text = transaction.date
                tvType.text = transaction.type
            }
        }
    }
}
