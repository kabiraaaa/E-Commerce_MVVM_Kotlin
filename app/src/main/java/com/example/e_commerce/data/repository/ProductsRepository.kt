package com.example.e_commerce.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce.data.source.api.ProductsApiService
import com.example.e_commerce.data.source.room_db.products.ProductsDatabase
import com.example.e_commerce.domain.models.productsItem
import com.example.e_commerce.domain.utils.NetworkUtils

class ProductsRepository(
    private val productsApiService: ProductsApiService,
    private val productsDatabase: ProductsDatabase,
    private val applicationContext: Context
) {
    private val TAG = "ProductsRepository"

    private val productsLiveData = MutableLiveData<List<productsItem>>()


    val products: LiveData<List<productsItem>>
        get() = productsLiveData

    suspend fun getProducts() {

        if (NetworkUtils.isNetworkAvailable(applicationContext)) {
            Log.d(TAG, "Internet Available- ${NetworkUtils.isNetworkAvailable(applicationContext)}")
            val result = productsApiService.getProducts()
            if (result.body() != null) {
                productsDatabase.productsDao().addProducts(result.body()!!)
                productsLiveData.postValue(result.body())
            }
        } else {
            Log.d(TAG, "Internet Available- ${NetworkUtils.isNetworkAvailable(applicationContext)}")
            val productsList = productsDatabase.productsDao().getProducts()
            productsLiveData.postValue(productsList)
        }

    }
}