package com.example.am_lakestan.data.repo

import com.example.am_lakestan.data.updates
import io.reactivex.Single

interface updateRepository {



    fun getUpdate():Single<List<updates>>





}