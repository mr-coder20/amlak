package com.example.am_lakestan.data.source

import com.example.am_lakestan.data.version
import com.example.am_lakestan.services.http.apiService
import io.reactivex.Completable
import io.reactivex.Single

class versionRemoteDataSource(val apiService: apiService): VersionDataSource {
    override fun getVersion(): Single<List<version>> =apiService.getVersion()


}