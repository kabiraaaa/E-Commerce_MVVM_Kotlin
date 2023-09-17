package com.example.e_commerce.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.data.repository.ProductsRepository
import com.example.e_commerce.domain.models.products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductsRepository) :ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO ) {
            repository.getProducts()
        }
    }

    val products : LiveData<products>
        get() = repository.products
}