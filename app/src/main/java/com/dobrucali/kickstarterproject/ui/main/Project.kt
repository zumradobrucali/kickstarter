package com.dobrucali.kickstarterproject.ui.main


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import org.joda.time.Days
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


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
    val url: String
) : Parcelable {

    val pledgedFormattedPrice
        get() = formattedPledge(amtPledged, currency)
    val leftDayCount
        get() = calculateLeftDayCount(endTime)



    private fun formattedPledge(amtPledged: Int, currency: String): String {
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance(currency)
        return format.format(amtPledged)
    }

    private fun calculateLeftDayCount(endTime: String): String {
        val formatter = DateTimeFormat.forPattern("YYYY-MM-DD'T'HH:mm:ssZZ")
        val endDate: LocalDate = LocalDate.parse(endTime, formatter)
        val currentDate: LocalDate = LocalDate.now()
        val days: Int = Days.daysBetween(currentDate, endDate).days
        return "$days days left"
    }

}


