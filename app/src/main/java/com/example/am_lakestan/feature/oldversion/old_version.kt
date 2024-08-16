package com.example.am_lakestan.feature.oldversion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.am_lakestan.R
import com.example.am_lakestan.common.language.setLanguage.Companion.setDefaultLocaleList

class old_version : AppCompatActivity() {

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
        setContentView(R.layout.activity_old_version)


        val oldversion_txt=findViewById<AppCompatTextView>(R.id.oldversion_txt)
        oldversion_txt.text=resources.getString(R.string.old_version)

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://divar.ir/download"))
        val update_btn=findViewById<AppCompatButton>(R.id.update_btn)
        update_btn.setOnClickListener{
            startActivity(intent)
        }
    }
}