package dev.matheusvict.nubankinterface

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import dev.matheusvict.nubankinterface.adapter.PaymentMethodsAdapter
import dev.matheusvict.nubankinterface.adapter.ProductAdapter
import dev.matheusvict.nubankinterface.databinding.ActivityMainBinding
import dev.matheusvict.nubankinterface.model.Payment
import dev.matheusvict.nubankinterface.model.Product

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var paymentMethodsAdapter: PaymentMethodsAdapter
    private lateinit var productAdapter: ProductAdapter
    private val paymentMethodeList: MutableList<Payment> = mutableListOf()
    private val productsList: MutableList<Product> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#6836BF")

        initPaymentMethodsRecyclerView()
        initProductsRecyclerView()

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

    private fun initProductsRecyclerView() {
        val productRecyclerView = binding.recyclerProducts

        productRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        productRecyclerView.setHasFixedSize(true)
        productAdapter = ProductAdapter(this, productsList)
        productRecyclerView.adapter = productAdapter
        setProductsList()
    }

    private fun setProductsList() {
        val products: MutableList<Product> = mutableListOf(
            Product("Participe da Promoção Tudo no Roxinho e concorra a..."),
            Product("Chegou o débito automático da fatura do cartão"),
            Product("Conheça a conta PJ: prática e livre de burocracia para se..."),
            Product("Salve seus amigos da burocracia: Faça um convite..."),
        )

        productsList.addAll(products)
    }
}