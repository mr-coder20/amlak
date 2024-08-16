package com.example.am_lakestan.feature.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.am_lakestan.R
import com.example.am_lakestan.common.amlakestanFragment

class CitiesFragment: amlakestanFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cities,container,false)
    }
}