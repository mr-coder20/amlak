package com.example.am_lakestan.data.source
import com.example.am_lakestan.data.product
import io.reactivex.Completable
import io.reactivex.Single



class productLocalDataSource: productDataSource {

    override fun getProducts(): Single<List<product>> {
        TODO("Not yet implemented")
    }


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