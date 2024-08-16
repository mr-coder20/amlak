package com.example.am_lakestan.data.repo

import com.example.am_lakestan.data.source.VersionDataSource
import com.example.am_lakestan.data.source.productDataSource
import com.example.am_lakestan.data.source.productLocalDataSource
import com.example.am_lakestan.data.version
import io.reactivex.Completable
import io.reactivex.Single

class versionRepositoryImpl(val  remoteDataSource: VersionDataSource,

) : versionRepository {
    override fun getVersion(): Single<List<version>> = remoteDataSource.getVersion()


}