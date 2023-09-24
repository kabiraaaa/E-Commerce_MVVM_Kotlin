package com.example.e_commerce.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class productsItem(
    var category: String,
    var description: String,
    @PrimaryKey
    var id: Int,
    var image: String,
    var price: Double,
    var title: String
)