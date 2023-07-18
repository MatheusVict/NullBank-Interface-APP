package dev.matheusvict.nubankinterface.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.matheusvict.nubankinterface.databinding.PaymentItemBinding
import dev.matheusvict.nubankinterface.model.Payment

class PaymentMethodsAdapter(private val context: Context, private val paymentList: MutableList<Payment>): RecyclerView.Adapter<PaymentMethodsAdapter.PaymentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val listItem = PaymentItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return PaymentViewHolder(listItem)
    }

    override fun getItemCount(): Int = paymentList.size

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val paymentItem = paymentList[position]

        holder.paymentIcon.setBackgroundResource(paymentItem.paymentIcon!!)
        holder.paymentTitle.text = paymentItem.title
    }

    inner class PaymentViewHolder(binding: PaymentItemBinding): RecyclerView.ViewHolder(binding.root) {
        val paymentIcon = binding.paymentIcon
        val paymentTitle = binding.paymentTittle
    }
}