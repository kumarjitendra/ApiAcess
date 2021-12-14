package com.example.apiAccess

import android.content.ContentValues
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apiAccess.reflection.Reflection
import com.google.gson.Gson
import org.json.JSONException
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingSupportObject =jsonToObject(Root::class.java, "api.json")

        Log.i(ContentValues.TAG, "onCreate: $loggingSupportObject")
    }
    /*
   * Required File Name and Class Type
   * Returns Class Object? form saved file
   * if any exception occurs it prints StackTrace
   */
    private fun jsonToObject(classType: Class<*>, fileName: String): Any? {
        return try {
            val jsonString = loadJsonFromAsset(fileName)
            if (!jsonString.isNullOrEmpty()) Gson().fromJson(jsonString, classType)
            else null
        } catch (e: JSONException) {
            e.printStackTrace()
            null
        }
    }

    /*
    * Required File Name
    * Reads JSON file saved in assets
    * Returns JSON in the form of String?
    * if any exception occurs it prints StackTrace
    */
    private fun loadJsonFromAsset(fileName: String): String? {
        return try {
            val inStream: InputStream = this.assets.open(fileName)
            val size: Int = inStream.available()
            val buffer = ByteArray(size)
            inStream.read(buffer)
            inStream.close()
            String(buffer, Charset.defaultCharset())
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
    }
}