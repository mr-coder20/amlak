package com.example.am_lakestan.feature.product

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.am_lakestan.R
import com.example.am_lakestan.common.amlakestanActivity
import com.example.am_lakestan.feature.introSlider.adapter.ImagePagerAdapter
import com.example.am_lakestan.common.language.setLanguage.Companion.setDefaultLocaleList
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.jar.Manifest

class ProductDetailadvertisementsActivity : amlakestanActivity() {


    val productDetailViewModel: ProductDetailViewModel by viewModel { parametersOf(intent.extras) }


    val compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val setLanguage = this.getSharedPreferences(
            "language", MODE_PRIVATE
        )

        val language: String? = setLanguage.getString("language", "")

        if (language!!.isNotEmpty()) {
            when {
                language == "fa" -> setDefaultLocaleList("fa", "IR", this)
                language == "en" -> setDefaultLocaleList("en", "US", this)
                language == "ar" -> setDefaultLocaleList("ar", "SA", this)
                else -> setDefaultLocaleList("fa", "IR", this)
            }
        }
        setContentView(R.layout.activity_product_detail_advertisements)
        initViews()



        productDetailViewModel.productLiveData.observe(this) {
            val viewPager: ViewPager2 = findViewById(R.id.view_pager)

            val image = productDetailViewModel.productLiveData.value!!.image
            val title = productDetailViewModel.productLiveData.value!!.title


            var mortgage = productDetailViewModel.productLiveData.value!!.mortgage
            var deposit = productDetailViewModel.productLiveData.value!!.deposit
            var monthly_rent = productDetailViewModel.productLiveData.value!!.monthly_rent
            var city = productDetailViewModel.productLiveData.value!!.city
            var state = productDetailViewModel.productLiveData.value!!.State
            var address = productDetailViewModel.productLiveData.value!!.address
            var category = productDetailViewModel.productLiveData.value!!.category
            var creator = productDetailViewModel.productLiveData.value!!.creator
            var Elevator = productDetailViewModel.productLiveData.value!!.Elevator
            var Parking = productDetailViewModel.productLiveData.value!!.Parking
            var Warehouse = productDetailViewModel.productLiveData.value!!.Warehouse
            var Meterage = productDetailViewModel.productLiveData.value!!.Meterage
            var Floor = productDetailViewModel.productLiveData.value!!.Floor
            var Year_of_construction =
                productDetailViewModel.productLiveData.value!!.Year_of_construction
            var Number_of_rooms = productDetailViewModel.productLiveData.value!!.Number_of_rooms
            var Description = productDetailViewModel.productLiveData.value!!.Description
            val titleTv: TextView = findViewById(R.id.title_tv)
            val city_tv: TextView = findViewById(R.id.city_tv)
            val ejare_tv: TextView = findViewById(R.id.ejare_tv)
            val vadie_tv: TextView = findViewById(R.id.vadie_tv)
            val rahn_tv: TextView = findViewById(R.id.rahn_tv)
            val addres: TextView = findViewById(R.id.address)
            val categories: TextView = findViewById(R.id.categories)

            val asansor: TextView = findViewById(R.id.asansor)
            val anbari: TextView = findViewById(R.id.anbari)
            val parking: TextView = findViewById(R.id.parking)
            val metrazh: TextView = findViewById(R.id.metrazh)
            val floor: TextView = findViewById(R.id.floor)
            val yearcreated: TextView = findViewById(R.id.yearcreated)
            val otagh: TextView = findViewById(R.id.otagh)
            val description: TextView = findViewById(R.id.description)
            val callinfo: ExtendedFloatingActionButton = findViewById(R.id.callinfo)

            callinfo.setOnClickListener{
                requestCallPermission(creator)
            }

            titleTv.text = title
            mortgage = mortgage.reversed().chunked(3).joinToString(separator = ",").reversed()
            deposit = deposit.reversed().chunked(3).joinToString(separator = ",").reversed()
            monthly_rent =
                monthly_rent.reversed().chunked(3).joinToString(separator = ",").reversed()
            city_tv.text = "${state}" + "," + " ${city}"
            addres.text = address


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
            metrazh.text = "متراژ\n\n${Meterage}"
            yearcreated.text = "سال ساخت\n\n${Year_of_construction}"
            description.text = Description

            if (Number_of_rooms == "0") {
                otagh.text = "تعداد اتاق\n\nبدون اتاق"
            } else {
                otagh.text = "تعداد اتاق\n\n${Number_of_rooms}"
            }


            if (Floor == "0") {
                floor.text = "طبقه\n\nهم کف"
            } else {
                floor.text = "طبقه\n\n${Floor}"
            }


            if (category == "shop") {
                categories.text = "نوع سازه\n\nمغازه و اداری"
            } else if (category == "apartment") {

                categories.text = "نوع سازه\n\nآپارتمان"
            } else if (category == "house") {
                categories.text = "نوع سازه\n\nخانه و ویلا"
            } else {
                categories.text = "نوع سازه\n\nنامشخص"
            }

            if (Elevator == "0") {
                asansor.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.no)

            } else if (Elevator == "1") {
                asansor.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.yes)


            } else {
                asansor.text = "نامشخص"


            }
            if (Parking == "0") {
                anbari.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.no)

            } else if (Parking == "1") {
                anbari.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.yes)


            } else {
                anbari.text = "نامشخص"
            }




            if (Warehouse == "0") {
                parking.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.no)

            } else if (Warehouse == "1") {
                parking.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.yes)


            } else {
                parking.text = "نامشخص"
            }


            val splitString = image.split("\",\"")

            val firstImageUrl = splitString.drop(0).dropLast(0)
            val newList = firstImageUrl.toMutableList()
            newList[0] = newList[0].substring(1)

            val adapter = ImagePagerAdapter(newList)

            viewPager.adapter = adapter


            val pageIndicator = findViewById<DotsIndicator>(R.id.pageIndicator)
            pageIndicator.attachTo(viewPager)

        }
        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener {
            finish()
        }
        productDetailViewModel.progressBarLiveData.observe(this) {
            setProgressIndicator(it)
        }


    }

    fun initViews() {


    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
    private fun showBottomSheetDialog(creator: String) {
        val bottomSheetDialog = BottomSheetDialog(this)
        val layout = layoutInflater.inflate(R.layout.dialog_layout_call, null)

//         Customize the layout as needed
        val call_tv: TextView = layout.findViewById(R.id.call_tv)
        val sms_tv: TextView = layout.findViewById(R.id.sms_tv)
        val dialog_button: Button = layout.findViewById(R.id.dialog_button)
        dialog_button.setOnClickListener{
            bottomSheetDialog.dismiss()
        }
        sms_tv.text=creator
        call_tv.text = creator
        call_tv.setOnClickListener{
             // Replace with the desired phone number
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$creator"))
            startActivity(intent)
        }
        sms_tv.setOnClickListener{
            // Replace with the desired phone number
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto:$creator")
            intent.putExtra("sms_body", "")
            startActivity(intent)
        }

        // Set the layout to the dialog
        bottomSheetDialog.setContentView(layout)

        // Show the dialog
        bottomSheetDialog.show()
    }

    private fun requestCallPermission(creator: String) {
        Dexter.withActivity(this)
            .withPermissions(android.Manifest.permission.CALL_PHONE)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    if (report!!.areAllPermissionsGranted()) {
                        showBottomSheetDialog(creator)
                    } else {
                        Toast.makeText(this@ProductDetailadvertisementsActivity, "Permission denied", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token!!.continuePermissionRequest()
                }
            })
            .check()
    }


}