package dev.matheusvict.nubankinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.matheusvict.nubankinterface.adapter.PaymentMethodsAdapter
import dev.matheusvict.nubankinterface.databinding.ActivityMainBinding
import dev.matheusvict.nubankinterface.model.Payment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var paymentMethodsAdapter: PaymentMethodsAdapter
    private val paymentMethodeList: MutableList<Payment> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initPaymentMethodsRecyclerView()

    }

    private fun initPaymentMethodsRecyclerView() {
        val recyclerViewPaymentIcons = binding.paymentMethodsRecyclerView

        recyclerViewPaymentIcons.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerViewPaymentIcons.setHasFixedSize(true)
        paymentMethodsAdapter = PaymentMethodsAdapter(this, paymentMethodeList)
        recyclerViewPaymentIcons.adapter = paymentMethodsAdapter
        setPaymentList()
    }

    private fun setPaymentList() {
        val paymentMethods = mutableListOf<Payment>(
            Payment(R.drawable.ic_pix, "Área Pix"),
            Payment(R.drawable.barcode, "Pagar"),
            Payment(R.drawable.emprestimo, "Pegar\nemprestado"),
            Payment(R.drawable.transferencia, "Transferir"),
            Payment(R.drawable.ic_phone_credit, "Recarga de celular"),
            Payment(R.drawable.ic_money_box, "Caixinha"),
            Payment(R.drawable.ic_demand, "Cobrar"),
            Payment(R.drawable.doacao, "Doação"),
            Payment(R.drawable.ic_invest, "Investir"),
            Payment(R.drawable.depositar, "Depositar"),
            Payment(R.drawable.ic_abroad_transfer, "Transferir\nInternacional.")
        )

        paymentMethodeList.addAll(paymentMethods)
    }
}