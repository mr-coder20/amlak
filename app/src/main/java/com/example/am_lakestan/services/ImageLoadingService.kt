package com.example.am_lakestan.services

interface ImageLoadingService {
    fun load(imageView: com.facebook.drawee.view.SimpleDraweeView, imageUrl: String)
}