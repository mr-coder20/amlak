package com.example.am_lakestan.common

import com.example.am_lakestan.R

import org.json.JSONObject
import retrofit2.HttpException
import timber.log.Timber

class AmlakestanExceptionMapper {
    companion object{
        fun map(throwable: Throwable): AmlakestanException {
            if (throwable is HttpException) {
                try {
                    val errorJsonObject = JSONObject(throwable.response()?.errorBody()!!.string())
                    val errorMessage=errorJsonObject.getString("message")
                    return AmlakestanException(if(throwable.code()==401 ) AmlakestanException.Type.AUTH else AmlakestanException.Type.SIMPLE, serverMessage = errorMessage)
                } catch (exception: Exception) {
                    Timber.e(exception)
                }

            }

                return AmlakestanException(AmlakestanException.Type.SIMPLE, R.string.internet_error)

        }
    }
}