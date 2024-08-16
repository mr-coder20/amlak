package com.example.am_lakestan.data.source

import com.example.am_lakestan.data.version
import io.reactivex.Completable
import io.reactivex.Single

interface VersionDataSource {

    fun getVersion(): Single<List<version>>

}