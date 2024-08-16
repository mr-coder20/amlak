package com.example.am_lakestan.data.source

import com.example.am_lakestan.data.product
import com.example.am_lakestan.services.http.apiService
import io.reactivex.Completable
import io.reactivex.Single

class productRemoteDataSource(val apiService: apiService): productDataSource {
    override fun getProducts(): Single<List<product>> =apiService.getProduct()

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