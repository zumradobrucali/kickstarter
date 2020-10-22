package com.dobrucali.kickstarterproject.ui.main


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Project(

    @Json(name = "s.no") val sNo: Int,
    @Json(name = "amt.pledged") val amtPledged: Int,
    val blurb: String,
    val by: String,
    val country: String,
    val currency: String,
    @Json(name = "end.time") val endTime: String,
    val location: String,
    @Json(name = "percentage.funded") val percentageFunded: Int,
    @Json(name = "num.backers") val numBackers: String,
    val state: String,
    val title: String,
    val type: String,
    val url: String) : Parcelable


