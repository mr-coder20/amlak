package com.example.am_lakestan.feature.introSlider.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.am_lakestan.R
import com.example.am_lakestan.feature.introSlider.fragments.IntroFragment


class IntroViewPagerAdapter(
    fragmentActivity: FragmentActivity, private val context: Context
) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> IntroFragment.newInstance(
                context.resources.getString(R.string.tenant),
                context.resources.getString(R.string.tenant_desc),
                R.raw.tenant
            )

            1 -> IntroFragment.newInstance(
                context.resources.getString(R.string.lessor),
                context.resources.getString(R.string.lessor_desc),
                R.raw.lessor
            )
            2 -> IntroFragment.newInstance(
                context.resources.getString(R.string.real_estate),
                context.resources.getString(R.string.real_estate_desc),
                R.raw.real_estate
            )
            else -> IntroFragment.newInstance(
                context.resources.getString(R.string.pricing),
                context.resources.getString(R.string.pricing_desc),
                R.raw.pricing
            )

        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}