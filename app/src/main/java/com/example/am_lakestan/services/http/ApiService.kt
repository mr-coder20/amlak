package com.example.am_lakestan.services.http
import com.example.am_lakestan.data.product
import com.example.am_lakestan.data.updates
import com.example.am_lakestan.data.version
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface
apiService {
    @GET("advertisements.php")
    fun getProduct(): Single<List<product>>


    @GET("version.php")
    fun getVersion(): Single<List<version>>

    @GET("updates.php")
    fun getUpdate(): Single<List<updates>>

}

fun createApiServiceInstance(): apiService {


    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())

        .build()

    return retrofit.create(apiService::class.java)

}