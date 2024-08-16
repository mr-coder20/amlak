package com.example.am_lakestan.common.language

import android.content.Context
import android.content.Intent
import com.example.am_lakestan.feature.introSlider.IntroActivity

class LocaleHelper {
    companion object {
        fun activityReStarter(context: Context) {

            val intent = Intent(context, IntroActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)

        }
    }
}