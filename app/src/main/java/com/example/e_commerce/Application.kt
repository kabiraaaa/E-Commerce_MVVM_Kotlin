package com.example.e_commerce

import android.app.Application
import com.example.e_commerce.domain.utils.Constants
import com.microsoft.clarity.Clarity
import com.microsoft.clarity.ClarityConfig

open class Application : Application() {

    private val TAG = "Application"
    override fun onCreate() {
        super.onCreate()
        val config = ClarityConfig(Constants.CLARITY_PROJECT_ID)
        Clarity.initialize(applicationContext, config)
    }
}