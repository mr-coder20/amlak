package com.example.am_lakestan.feature.product

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.am_lakestan.common.EXTRA_KEY_DATA
import com.example.am_lakestan.common.amlakestanViewModel
import com.example.am_lakestan.data.product

class ProductDetailViewModel(bundle: Bundle ): amlakestanViewModel() {

val productLiveData=MutableLiveData<product>()
    init {
        productLiveData.value = bundle.getParcelable(EXTRA_KEY_DATA)




    }

}