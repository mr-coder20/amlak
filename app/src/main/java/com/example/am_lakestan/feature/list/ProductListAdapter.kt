package com.example.am_lakestan.feature.list

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.am_lakestan.R
import com.example.am_lakestan.common.implementSpringAnimationTrait
import com.example.am_lakestan.data.product
import com.example.am_lakestan.services.ImageLoadingService
import com.facebook.drawee.view.SimpleDraweeView

const val VIEW_TYPE_ROUND = 0
const val VIEW_TYPE_SMALL = 1
const val VIEW_TYPE_LARGE = 2

class ProductListAdapter(
    var viewType: Int = VIEW_TYPE_ROUND,
    val imageLoadingService: ImageLoadingService
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    var popularproductLiveData: ProductOnClickListener? = null
    var latestproductLiveData: ProductOnClickListener? = null
    var products = ArrayList<product>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productIv: SimpleDraweeView = itemView.findViewById(R.id.productIv)

        val titleTv: TextView = itemView.findViewById(R.id.title_tv)
        val city_tv: TextView = itemView.findViewById(R.id.city_tv)
        val ejare_tv: TextView = itemView.findViewById(R.id.ejare_tv)
        val vadie_tv: TextView = itemView.findViewById(R.id.vadie_tv)
        val rahn_tv: TextView = itemView.findViewById(R.id.rahn_tv)

        fun BindProduct(product: product) {



            val image = product.image
            val splitString = image.split("\",\"")

            val firstImageUrl = splitString[0].drop(1).dropLast(0)
            println("First image URL: $firstImageUrl")
            imageLoadingService.load(productIv, firstImageUrl)

            titleTv.text = product.title


            val mortgage = product.mortgage.reversed().chunked(3).joinToString(separator = ",").reversed()
            val deposit = product.deposit.reversed().chunked(3).joinToString(separator = ",").reversed()
            val monthly_rent = product.monthly_rent.reversed().chunked(3).joinToString(separator = ",").reversed()



            city_tv.text="${product.State}"+","+" ${product.city}"

            if (mortgage == "0") {
                rahn_tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.no)
            } else {
                rahn_tv.text = "رهن\n\n${mortgage}"
            }
            if (deposit == "0") {
                vadie_tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.no)
            } else {
                vadie_tv.text = "ودیعه\n\n${deposit}"
            }
            if (monthly_rent == "0") {
                ejare_tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.no)
            } else {
                ejare_tv.text = "اجاره\n\n${monthly_rent}"
            }




            itemView.implementSpringAnimationTrait()
            itemView.setOnClickListener {
                popularproductLiveData?.onProductClick(product)
                latestproductLiveData?.onProductClick(product)
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutResId = when (viewType) {
            VIEW_TYPE_ROUND -> R.layout.item_product
            VIEW_TYPE_SMALL -> R.layout.item_product
            VIEW_TYPE_LARGE -> R.layout.item_product
            else -> throw IllegalStateException("ViewType is Unknown")
        }
        return ViewHolder(LayoutInflater.from(parent.context).inflate(layoutResId, parent, false))
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.BindProduct(products[position])

    interface ProductOnClickListener {
        fun onProductClick(product: product)
    }

}