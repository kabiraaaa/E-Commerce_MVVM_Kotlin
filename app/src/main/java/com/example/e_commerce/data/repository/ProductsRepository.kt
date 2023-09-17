package com.example.e_commerce.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce.data.source.ProductsApiService
import com.example.e_commerce.domain.models.products

class ProductsRepository(private val productsApiService: ProductsApiService) {

    private val productsLiveData = MutableLiveData<products>()

    val products : LiveData<products>
        get() = productsLiveData

    suspend fun getProducts() {
        val result = productsApiService.getProducts()
        if (result?.body() != null){
            productsLiveData.postValue(result.body())
        }
    }
}