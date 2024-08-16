package com.example.am_lakestan.data.source

import com.example.am_lakestan.data.product
import io.reactivex.Completable
import io.reactivex.Single

interface productDataSource {

    fun getProducts(): Single<List<product>>

    fun getFavoriteProduct(): Single<List<product>>

    fun addToFavorite(): Completable

    fun deleteFromFavorite(): Completable
}