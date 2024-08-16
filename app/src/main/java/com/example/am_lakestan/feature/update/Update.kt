package com.example.am_lakestan.feature.update


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

import com.example.am_lakestan.R
import com.example.am_lakestan.common.language.setLanguage.Companion.setDefaultLocaleList

class Update : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val setLanguage = this.getSharedPreferences(
            "language", MODE_PRIVATE
        )
        val language: String? = setLanguage.getString("language", "")

        if (language!!.isNotEmpty()) {
            when {
                language == "fa" -> setDefaultLocaleList("fa", "IR",this)
                language == "en" -> setDefaultLocaleList("en", "US",this)
                language == "ar" -> setDefaultLocaleList("ar", "SA",this)
                else -> setDefaultLocaleList("fa", "IR",this)
            }
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update)


        val update_txt=findViewById<AppCompatTextView>(R.id.update_txt)
        update_txt.text=resources.getString(R.string.update)

        val exit_btn=findViewById<AppCompatButton>(R.id.exit_btn)
        exit_btn.setOnClickListener{
            finish()
        }
    }
}