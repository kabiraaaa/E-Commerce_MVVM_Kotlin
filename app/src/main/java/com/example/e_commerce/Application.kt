package com.example.e_commerce

import android.app.Application
import com.example.e_commerce.data.repository.ProductsRepository
import com.example.e_commerce.data.source.api.ProductsApiService
import com.example.e_commerce.data.source.api.RetroFitHelper
import com.example.e_commerce.data.source.room_db.products.ProductsDatabase
import com.example.e_commerce.domain.utils.Constants
import com.microsoft.clarity.Clarity
import com.microsoft.clarity.ClarityConfig

open class Application : Application() {

    lateinit var productsRepository: ProductsRepository

    private val TAG = "Application"
    override fun onCreate() {
        super.onCreate()
        initializeClarity()
        initializeRepository()

    }

    private fun initializeClarity() {
        val config = ClarityConfig(Constants.CLARITY_PROJECT_ID)
        Clarity.initialize(applicationContext, config)
    }

    private fun initializeRepository() {
        val productService = RetroFitHelper.getInstance().create(ProductsApiService::class.java)
        val database = ProductsDatabase.getProductDatabase(this)
        productsRepository = ProductsRepository(productService, database, applicationContext)
    }
}