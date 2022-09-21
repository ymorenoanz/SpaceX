package com.yaritzama.spacex.domain.helpers

import android.content.res.Resources.NotFoundException
import java.text.SimpleDateFormat
import java.util.*

fun String.ToFormatDate(): String{
    return try {
        val apiFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val newDate = apiFormat.parse(this)
        val domainFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        val stringDate = newDate?.let { domainFormat.format(it) }
        stringDate ?: "It's not in a valid format"
    } catch (e: Exception) {
        "It's not in a valid format"
    }
}

fun String.ToDate(): Date{
      val apiFormat =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
      return apiFormat.parse(this)?:throw Exception("Date invalid")
}