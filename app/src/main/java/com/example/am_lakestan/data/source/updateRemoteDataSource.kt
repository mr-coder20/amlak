package com.example.am_lakestan.data.source

import com.example.am_lakestan.data.updates
import com.example.am_lakestan.services.http.apiService
import io.reactivex.Single

class updateRemoteDataSource(val apiService: apiService): UpdateDataSource {
    override fun getUpdate(): Single<List<updates>> =apiService.getUpdate()
    }


