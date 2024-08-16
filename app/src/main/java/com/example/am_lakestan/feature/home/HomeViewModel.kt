package com.example.am_lakestan.feature.home

import androidx.lifecycle.MutableLiveData
import com.example.am_lakestan.common.AmlakestanSingleObserver
import com.example.am_lakestan.common.amlakestanViewModel
import com.example.am_lakestan.data.product

import com.example.am_lakestan.data.repo.productRepository
import com.example.am_lakestan.data.repo.updateRepository
import com.example.am_lakestan.data.repo.versionRepository
import com.example.am_lakestan.data.updates
import com.example.am_lakestan.data.version
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class mainViewModel(productRepository: productRepository,versionRepository: versionRepository,updateRepository: updateRepository) :
    amlakestanViewModel() {
    val latestproductLiveData = MutableLiveData<List<product>>()
    val version = MutableLiveData<List<version>>()
    val updates = MutableLiveData<List<updates>>()


    init {







        progressBarLiveData.value = true
        productRepository.getProducts()

            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : AmlakestanSingleObserver<List<product>>(CompositeDisposable) {
                override fun onSuccess(t: List<product>) {
                    latestproductLiveData.value = t
                }

            })





            versionRepository.getVersion()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : AmlakestanSingleObserver<List<version>>(CompositeDisposable) {
                override fun onSuccess(t: List<version>) {
                    version.value = t
                }

            })




        updateRepository.getUpdate()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : AmlakestanSingleObserver<List<updates>>(CompositeDisposable) {
                override fun onSuccess(t: List<updates>) {
                    updates.value = t
                }

            })





    }
}