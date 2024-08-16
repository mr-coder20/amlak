package com.example.am_lakestan.common.language

import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
class setLanguage:AppCompatActivity() {
    companion object {

        fun setDefaultLocaleList(language: String, country: String,context: Context) {
            val locale = Locale(
                language,
                country
            ) // fa is the language code for Persian, IR is the country code for Iran
            Locale.setDefault(locale)

            val config = context.resources.configuration
            config.locale = locale
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }
    }
}