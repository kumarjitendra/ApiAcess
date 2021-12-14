package com.example.apiAccess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import getJsonDataFromAsset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "api.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
    }
}