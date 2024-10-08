package com.example.am_lakestan.common

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.example.am_lakestan.R

import io.reactivex.disposables.CompositeDisposable
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


abstract class amlakestanFragment : amlakestanView, Fragment() {
    override val rootView: CoordinatorLayout?
        get() = view as CoordinatorLayout

    override val viewContext: Context?
        get() = context

    override fun onStart() {
        super.onStart()

        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)

    }
}

abstract class amlakestanActivity : amlakestanView, AppCompatActivity() {
    override val rootView: CoordinatorLayout?
        get() {
            val viewGroup: ViewGroup = window.decorView.findViewById(android.R.id.content)
            if (viewGroup !is CoordinatorLayout) {
                viewGroup.children.forEach {
                    if (it is CoordinatorLayout) return it
                }
                throw IllegalStateException("RootView must be instance of CoordinatorLayout")
            } else return viewGroup
        }
    override val viewContext: Context?
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}

interface amlakestanView {
    val rootView: CoordinatorLayout?
    val viewContext: Context?
    fun setProgressIndicator(muatShow: Boolean) {

        rootView?.let {
            viewContext?.let { context ->
                var loadingView = it.findViewById<View>(R.id.loadingView)
                if (loadingView == null && muatShow) {
                    loadingView =
                        LayoutInflater.from(context).inflate(R.layout.view_loading, it, false)
                    it.addView(loadingView)
                }
                loadingView?.visibility = if (muatShow) View.VISIBLE else View.GONE
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun showError(amlakestanException: AmlakestanException) {



                when (amlakestanException.type) {
                    AmlakestanException.Type.SIMPLE ->
                        showSnakebar(
                        amlakestanException.serverMessage
                            ?: viewContext!!.getString(amlakestanException.userFriendlyMessage)
                    )

                    AmlakestanException.Type.AUTH -> {




                    }

                    AmlakestanException.Type.DIALOG -> TODO()
                }




        }


    fun showSnakebar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
        rootView?.let {
            Snackbar.make(it, message, duration).show()
        }
    }
}

abstract class amlakestanViewModel : ViewModel() {
    val CompositeDisposable = CompositeDisposable()
    val progressBarLiveData = MutableLiveData<Boolean>()
    override fun onCleared() {
        CompositeDisposable.clear()
        super.onCleared()
    }
}