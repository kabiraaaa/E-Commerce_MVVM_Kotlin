package com.example.e_commerce.data.source.api

import com.example.e_commerce.domain.models.productsItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApiService {
    @GET("/products")
    suspend fun getProducts():Response<List<productsItem>>
}