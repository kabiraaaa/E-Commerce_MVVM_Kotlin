package com.example.e_commerce.data.source.room_db.products

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_commerce.domain.models.productsItem

@Database(entities = [productsItem::class], version = 1, exportSchema = false)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductsDao

    companion object {
        private var INSTANCE: ProductsDatabase? = null

        fun getProductDatabase(context: Context): ProductsDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, ProductsDatabase::class.java, "productsDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}