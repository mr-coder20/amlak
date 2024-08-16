package com.example.am_lakestan.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class product(

    val id: Int,
    var image: String,

    val status: Int,
    val title: String,
    val deposit: String,
    val address: String,
    val Description: String,
    val Elevator: String,
    val Floor: String,
    val Meterage: String,
    val Number_of_rooms: String,
    val Parking: String,
    val State: String,
    val Warehouse: String,
    val Year_of_construction: String,
    val category: String,
    val city: String,
    val create_time: String,
    val creator: String,
    val monthly_rent: String,
    val exeption: String,
    val mortgage: String,

    ) : Parcelable

