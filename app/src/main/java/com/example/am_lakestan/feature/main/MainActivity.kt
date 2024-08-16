package com.example.am_lakestan.feature.main


import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.am_lakestan.R
import com.example.am_lakestan.common.EXTRA_KEY_DATA
import com.example.am_lakestan.common.amlakestanActivity
import com.example.am_lakestan.common.language.setLanguage.Companion.setDefaultLocaleList
import com.example.am_lakestan.feature.cities.CitiesFragment
import com.example.am_lakestan.feature.home.MainFragment
import com.example.am_lakestan.feature.home.mainViewModel
import com.example.am_lakestan.feature.profile.ProfileFragment
import com.example.am_lakestan.feature.introSlider.IntroActivity
import com.example.am_lakestan.feature.moshaver.moshaverFragment
import com.example.am_lakestan.feature.oldversion.old_version
import com.example.am_lakestan.feature.setting.settingFragment
import com.example.am_lakestan.feature.update.Update
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : amlakestanActivity() {
    private val sharedPref: SharedPreferences by inject()
    val mainViewModel: mainViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {





        window.navigationBarColor = resources.getColor(R.color.md_grey_200)


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

        mainViewModel.updates.observe(this) { a ->
            mainViewModel.version.observe(this) { b ->
                var update = a
                var version = b






                when {
                    update.toString() != ("[updates(updates=0)]") -> {
                        startActivity(Intent(this, Update::class.java).apply {
                            finish()
                            putExtra(EXTRA_KEY_DATA, update.toString())
                        })
                    }

                    version.toString() != ("[version(version=1)]") -> {
                        startActivity(Intent(this, old_version::class.java).apply {
                            finish()
                            putExtra(EXTRA_KEY_DATA, version.toString())
                        })
                    }

                    else -> {
                        val stringValue: String? = sharedPref.getString("intro_slider", "")
                        if (stringValue == "intro") {
                            setContentView(R.layout.activity_main)
                            loadFragment(MainFragment())
                            val bottomNavigationMain: ChipNavigationBar =
                                findViewById(R.id.bottomNavigationMain)
                            bottomNavigationMain.setItemSelected( R.id.home)


                            val activity =this
                            val window = activity.window
                            window.setBackgroundDrawableResource(R.drawable.gradiant_statusbar1)


                            bottomNavigationMain.setOnItemSelectedListener {
                                when (it) {
                                    R.id.home -> {
                                        loadFragment(MainFragment())
                                        val activity =this
                                        val window = activity.window
                                        window.setBackgroundDrawableResource(R.drawable.gradiant_statusbar1)

                                        true
                                    }

                                    R.id.cities -> {
                                        loadFragment(CitiesFragment())
                                        val activity =this
                                        val window = activity.window
                                        window.setBackgroundDrawableResource(R.drawable.gradiant_statusbar2)
                                        true
                                    }

                                    R.id.profile -> {
                                        loadFragment(ProfileFragment())
                                        val activity =this
                                        val window = activity.window
                                        window.setBackgroundDrawableResource(R.drawable.gradiant_statusbar3)
                                        true
                                    }
                                    R.id.setting -> {
                                        loadFragment(settingFragment())
                                        val activity =this
                                        val window = activity.window
                                        window.setBackgroundDrawableResource(R.drawable.gradiant_statusbar4)
                                        true
                                    }
                                    R.id.moshaver -> {
                                        loadFragment(moshaverFragment())
                                        val activity =this
                                        val window = activity.window
                                        window.setBackgroundDrawableResource(R.drawable.gradiant_statusbar5)
                                        true
                                    }

                                    else -> {
                                        loadFragment(MainFragment())
                                        val activity =this
                                        val window = activity.window
                                        window.setBackgroundDrawableResource(R.drawable.gradiant_statusbar1)
                                        true
                                    }

                                }
                            }


                        } else {
                            finish()
                            startActivity(Intent(this, IntroActivity::class.java).apply {
                                var a = 0
                                putExtra(EXTRA_KEY_DATA, a)
                            })

                        }


                    }

                }
            }


        }
    }


    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_container, fragment)
        transaction.commit()
    }


}





