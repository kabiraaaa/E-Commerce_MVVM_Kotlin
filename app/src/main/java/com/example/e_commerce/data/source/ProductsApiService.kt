package com.example.e_commerce.data.source

import retrofit2.Response
import com.example.e_commerce.domain.models.products
import retrofit2.http.GET

interface ProductsApiService {
    @GET("/products")
    suspend fun getProducts():Response<products>
}