package com.example.am_lakestan

import android.app.Application
import android.content.SharedPreferences
import android.os.Bundle
import com.facebook.drawee.backends.pipeline.Fresco
import com.example.am_lakestan.data.repo.productRepository
import com.example.am_lakestan.data.repo.productRepositoryImpl
import com.example.am_lakestan.data.repo.updateRepository
import com.example.am_lakestan.data.repo.versionRepository
import com.example.am_lakestan.data.repo.versionRepositoryImpl

import com.example.am_lakestan.data.source.productLocalDataSource
import com.example.am_lakestan.data.source.productRemoteDataSource
import com.example.am_lakestan.data.source.updateRemoteDataSource
import com.example.am_lakestan.data.source.versionRemoteDataSource

import com.example.am_lakestan.feature.product.ProductDetailViewModel
import com.example.am_lakestan.feature.list.ProductListAdapter
import com.example.am_lakestan.feature.home.mainViewModel
import com.example.am_lakestan.services.ImageLoadingService
import com.example.am_lakestan.services.http.FrescoImageLoadingService
import com.example.am_lakestan.services.http.createApiServiceInstance
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber
import updateRepositoryImpl


class App : Application() {

    override fun onCreate() {

        Timber.plant(Timber.DebugTree())
        Fresco.initialize(this)
        super.onCreate()

        val myModules = module {
            single { createApiServiceInstance() }
            single<ImageLoadingService> { FrescoImageLoadingService() }
            factory<productRepository> {
                productRepositoryImpl(
                    productRemoteDataSource(get()),
                    productLocalDataSource()

                )
            }
            factory<versionRepository> {
                versionRepositoryImpl(
                    versionRemoteDataSource(get())

                )
            }
            factory<updateRepository> {
                updateRepositoryImpl(
                    updateRemoteDataSource(get())

                )
            }
            single<SharedPreferences> {
                this@App.getSharedPreferences(
                    "app_settings",
                    MODE_PRIVATE
                )
            }






            factory { (viewType: Int) -> ProductListAdapter(viewType,get() ) }

            viewModel { mainViewModel(get(),get(),get()) }
            viewModel { (bundle: Bundle) -> ProductDetailViewModel(bundle)}


        }
        startKoin {
            androidContext(this@App)
            modules(myModules)

        }


    }

}
