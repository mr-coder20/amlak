package com.example.am_lakestan.feature.home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.graphics.Color
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.am_lakestan.common.EXTRA_KEY_DATA
import com.example.am_lakestan.R
import com.example.am_lakestan.common.amlakestanFragment
import com.example.am_lakestan.data.product
import com.example.am_lakestan.feature.list.ProductListAdapter
import com.example.am_lakestan.feature.list.VIEW_TYPE_ROUND
import com.example.am_lakestan.feature.product.ProductDetailadvertisementsActivity
import com.example.am_lakestan.common.language.setLanguage.Companion.setDefaultLocaleList
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MainFragment : amlakestanFragment(), ProductListAdapter.ProductOnClickListener {
    val mainViewModel: mainViewModel by viewModel()
    val latestproductListAdapter: ProductListAdapter by inject { parametersOf(VIEW_TYPE_ROUND) }





    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {



        val setLanguage = this.viewContext?.getSharedPreferences(
            "language", MODE_PRIVATE
        )

        val language: String? = setLanguage?.getString("language", "")

        if (language!!.isNotEmpty()) {
            when {
                language == "fa" -> setDefaultLocaleList("fa", "IR", requireContext())
                language == "en" -> setDefaultLocaleList("en", "US", requireContext())
                language == "ar" -> setDefaultLocaleList("ar", "SA", requireContext())
                else -> setDefaultLocaleList("fa", "IR", requireContext())
            }
        }

        return inflater.inflate(R.layout.fragment_home, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val latestProductsRv = view.findViewById<RecyclerView>(R.id.latestProductsRv)








        val logo_txt = view.findViewById<TextView>(R.id.logo_txt)
        logo_txt.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_logo)

        latestProductsRv.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

//val status_tb=view.findViewById<Toolbar>(R.id.status_tb)
//        status_tb.se
        latestProductsRv.adapter = latestproductListAdapter

        latestproductListAdapter.latestproductLiveData = this
        mainViewModel.latestproductLiveData.observe(viewLifecycleOwner) {

            latestproductListAdapter.products = it as ArrayList<product>
        }





        mainViewModel.progressBarLiveData.observe(viewLifecycleOwner) {
            setProgressIndicator(it)


        }
    }


    override fun onProductClick(product: product) {
        startActivity(Intent(requireContext(), ProductDetailadvertisementsActivity::class.java).apply {
            putExtra(EXTRA_KEY_DATA, product)
        })
    }




}