package com.example.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.e_commerce.data.repository.ProductsRepository
import com.example.e_commerce.data.source.api.ProductsApiService
import com.example.e_commerce.data.source.api.RetroFitHelper
import com.example.e_commerce.data.source.room_db.products.ProductsDatabase
import com.example.e_commerce.databinding.ActivityMainBinding
import com.example.e_commerce.ui.adapter.ProductListAdapter
import com.example.e_commerce.ui.viewmodels.MainViewModel
import com.example.e_commerce.ui.viewmodelsFactory.MainViewModelFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var productsAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val repository = (application as Application).productsRepository

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.products.observe(this) {
            productsAdapter = ProductListAdapter(it)
            binding.rvProducts.layoutManager = GridLayoutManager(this@MainActivity, 2)
            binding.rvProducts.adapter = productsAdapter
            Log.d(TAG, "Products- $it")
        }
    }
}
