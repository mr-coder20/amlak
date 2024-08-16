package com.example.am_lakestan.feature.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.am_lakestan.R
import com.example.am_lakestan.common.amlakestanFragment

class CartFragment: amlakestanFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart,container,false)

    }
}