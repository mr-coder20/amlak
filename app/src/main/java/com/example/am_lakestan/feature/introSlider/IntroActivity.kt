package com.example.am_lakestan.feature.introSlider


import CenterDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.am_lakestan.R
import com.example.am_lakestan.common.EXTRA_KEY_DATA
import com.example.am_lakestan.databinding.ActivityIntroBinding
import com.example.am_lakestan.feature.main.MainActivity
import com.example.am_lakestan.feature.introSlider.adapter.IntroViewPagerAdapter
import com.example.am_lakestan.common.language.setLanguage.Companion.setDefaultLocaleList
import org.koin.android.ext.android.inject
import timber.log.Timber


class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    private val sharedPref: SharedPreferences by inject()


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        val setLanguage = this.getSharedPreferences(
            "language", MODE_PRIVATE
        )

        val language: String? = setLanguage.getString("language", "")

        if (language!!.isNotEmpty()) {
            when {
                language == "fa" -> setDefaultLocaleList("fa", "IR", this)
                language == "en" -> setDefaultLocaleList("en", "US", this)
                language == "ar" -> setDefaultLocaleList("ar", "SA", this)
                else -> setDefaultLocaleList("fa", "IR", this)
            }
        }


        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = resources.getColor(R.color.md_green_200)
        window.navigationBarColor = resources.getColor(R.color.md_white_1000)

        binding.apply {

            viewPager.adapter = IntroViewPagerAdapter(
                this@IntroActivity, this@IntroActivity
            )
            pageIndicator.attachTo(viewPager)


            btnCreateAccount.setOnClickListener {
                val currentPage = viewPager.currentItem


                if (currentPage == 0) {


                    viewPager.setCurrentItem(currentPage + 1, true)

                } else if (currentPage == 1) {

                    viewPager.setCurrentItem(currentPage + 1, true)

                } else if (currentPage == 2) {

                    viewPager.setCurrentItem(currentPage + 1, true)

                } else if (currentPage == 3) {

                    sharedPref.edit().apply {
                        val introDone = "intro"
                        putString("intro_slider", introDone)
                    }.apply()
                    finishAffinity()

                    startActivity(Intent(
                        this@IntroActivity, MainActivity::class.java
                    ).apply {
                        var a = 0
                        putExtra(EXTRA_KEY_DATA, a)
                    })


                }
            }



            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    // This method is called when the user scrolls the ViewPager
                }

                override fun onPageSelected(position: Int) {
                    // This method is called when a new page is selected
                    // You can get the current item using the position parameter
                    val currentItem = position
                    if(currentItem==3 ) {
                        btnCreateAccount.text = getString(R.string.start)
                    }else{
                        btnCreateAccount.text = getString(R.string.next)

                    }

                }

                override fun onPageScrollStateChanged(state: Int) {
                    // This method is called when the scroll state of the ViewPager changes
                }
            })

        }



        binding.imChangeLanguage.setOnClickListener {
            val dialog = CenterDialog(this)
            dialog.show()
        }


    }


}
