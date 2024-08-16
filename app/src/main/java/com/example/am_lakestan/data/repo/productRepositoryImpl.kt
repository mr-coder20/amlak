package com.example.am_lakestan.data.repo

import com.example.am_lakestan.data.product
import com.example.am_lakestan.data.source.productDataSource
import com.example.am_lakestan.data.source.productLocalDataSource
import io.reactivex.Completable
import io.reactivex.Single

class productRepositoryImpl(val  remoteDataSource: productDataSource,
                            val  localDataSource: productLocalDataSource
) : productRepository {
    override fun getProducts(): Single<List<product>> = remoteDataSource.getProducts()

    override fun getFavoriteProduct(): Single<List<product>> {
        TODO("Not yet implemented")
    }

    override fun addToFavorite(): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteFromFavorite(): Completable {
        TODO("Not yet implemented")
    }
}