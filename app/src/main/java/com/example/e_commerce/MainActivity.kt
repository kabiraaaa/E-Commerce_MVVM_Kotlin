package com.example.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.e_commerce.data.repository.ProductsRepository
import com.example.e_commerce.data.source.api.ProductsApiService
import com.example.e_commerce.data.source.api.RetroFitHelper
import com.example.e_commerce.databinding.ActivityMainBinding
import com.example.e_commerce.ui.viewmodels.MainViewModel
import com.example.e_commerce.ui.viewmodelsFactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productService = RetroFitHelper.getInstance().create(ProductsApiService::class.java)
        val repository = ProductsRepository(productService)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.products.observe(this, Observer {
            Log.d("Helloo",it.toString())
        })
    }
}