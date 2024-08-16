package com.example.am_lakestan.common

import androidx.annotation.StringRes

class AmlakestanException(val type: Type, @StringRes val userFriendlyMessage:Int=0
                          , val serverMessage:String?=null):Throwable() {

    enum class Type{

        SIMPLE,DIALOG,AUTH
    }
}