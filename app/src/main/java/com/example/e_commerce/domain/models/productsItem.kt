package com.example.e_commerce.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class productsItem(
    val category: String,
    val description: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)