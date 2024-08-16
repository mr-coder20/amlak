package com.example.am_lakestan.data.source

import com.example.am_lakestan.data.updates
import io.reactivex.Single

interface UpdateDataSource {

    fun getUpdate(): Single<List<updates>>

}