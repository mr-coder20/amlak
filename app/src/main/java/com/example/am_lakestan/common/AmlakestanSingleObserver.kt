package com.example.am_lakestan.common

import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus
import timber.log.Timber

abstract class AmlakestanSingleObserver<T>(val CompositeDisposable: CompositeDisposable):SingleObserver<T> {
    override fun onError(e: Throwable) {
        EventBus.getDefault().post(AmlakestanExceptionMapper.map( e))

        Timber.e(e)
    }

    override fun onSubscribe(d: Disposable) {

        CompositeDisposable.add(d)

    }
}