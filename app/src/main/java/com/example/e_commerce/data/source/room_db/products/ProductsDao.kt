package com.example.e_commerce.data.source.room_db.products

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.e_commerce.domain.models.productsItem

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProducts(products: List<productsItem>)

    @Query("SELECT * FROM products")
    fun getProducts(): List<productsItem>
}