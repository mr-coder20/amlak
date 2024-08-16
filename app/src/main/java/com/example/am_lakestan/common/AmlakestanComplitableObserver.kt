package com.example.am_lakestan.common

import io.reactivex.CompletableObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus
import timber.log.Timber

abstract class AmlakestanComplitableObserver(val compositeDisposable: CompositeDisposable):CompletableObserver {
    override fun onError(e: Throwable) {
        EventBus.getDefault().post(AmlakestanExceptionMapper.map(e))

        Timber.e(e)
    }

    override fun onSubscribe(d: Disposable) {
compositeDisposable.add(d)
    }
}