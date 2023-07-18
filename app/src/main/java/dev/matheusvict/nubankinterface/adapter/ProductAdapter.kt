package dev.matheusvict.nubankinterface.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.matheusvict.nubankinterface.databinding.ProductItemBinding
import dev.matheusvict.nubankinterface.model.Product

class ProductAdapter(private val context: Context, private val productList: MutableList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemList = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(itemList)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.informativeText.text = product.text
    }

    inner class ProductViewHolder(binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val informativeText = binding.informativeText
    }
}