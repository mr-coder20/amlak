package com.example.am_lakestan.data.repo

import com.example.am_lakestan.data.version
import io.reactivex.Completable
import io.reactivex.Single

interface versionRepository {



    fun getVersion():Single<List<version>>





}