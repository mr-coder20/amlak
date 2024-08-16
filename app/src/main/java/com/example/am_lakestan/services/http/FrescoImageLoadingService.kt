package com.example.am_lakestan.services.http

import com.facebook.drawee.view.SimpleDraweeView
import com.example.am_lakestan.services.ImageLoadingService
import java.lang.IllegalStateException

class FrescoImageLoadingService: ImageLoadingService {
    override fun load(imageView: SimpleDraweeView, imageUrl: String) {
        if (true)
            imageView.setImageURI(imageUrl)
        else
            throw IllegalStateException("ImageView Must Be Instance Of SimpleDraweeView")
    }

}