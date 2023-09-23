package com.example.e_commerce

import android.app.Application
import com.microsoft.clarity.Clarity
import com.microsoft.clarity.ClarityConfig

open class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        val config = ClarityConfig("izlxdy6eov")
        Clarity.initialize(applicationContext, config)
    }
}