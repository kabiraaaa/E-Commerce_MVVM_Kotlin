package com.example.e_commerce.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce.data.source.api.ProductsApiService
import com.example.e_commerce.data.source.room_db.products.ProductsDatabase
import com.example.e_commerce.domain.models.products

class ProductsRepository(private val productsApiService: ProductsApiService, private val productsDatabase: ProductsDatabase) {

    private val productsLiveData = MutableLiveData<products>()


    val products : LiveData<products>
        get() = productsLiveData

    suspend fun getProducts() {
        val result = productsApiService.getProducts()
        if (result.body() != null){
            productsDatabase.productsDao().addProducts(result.body()!!)
            productsLiveData.postValue(result.body())
        }
    }
}