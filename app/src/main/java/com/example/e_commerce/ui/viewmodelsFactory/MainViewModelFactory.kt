package com.example.e_commerce.ui.viewmodelsFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_commerce.data.repository.ProductsRepository
import com.example.e_commerce.ui.viewmodels.MainViewModel

class MainViewModelFactory(private val repository: ProductsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}