package com.example.e_commerce.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.databinding.RvProductCardViewBinding
import com.example.e_commerce.domain.models.productsItem


class ProductListAdapter(dataList: List<productsItem>) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    private val dataList: List<productsItem>

    init {
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RvProductCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: productsItem = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(private val binding: RvProductCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(products: productsItem) {
            binding.tvProdName.text = products.title
            binding.tvProductPrice.text = products.price.toString()
        }
    }
}
