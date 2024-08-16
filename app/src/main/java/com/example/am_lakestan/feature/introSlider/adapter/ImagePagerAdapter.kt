package com.example.am_lakestan.feature.introSlider.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.am_lakestan.R
import com.facebook.drawee.view.SimpleDraweeView

class ImagePagerAdapter(private val imageUrls: List<String>) : RecyclerView.Adapter<ImagePagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUri = Uri.parse(imageUrls[position])
        holder.imageView.setImageURI(imageUri)
    }

    override fun getItemCount(): Int {
        return imageUrls.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: SimpleDraweeView = itemView.findViewById(R.id.image_view)
    }
}