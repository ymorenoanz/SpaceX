package com.yaritzama.spacex.data.models


import com.google.gson.annotations.SerializedName

data class LaunchFailureDetails(
    @SerializedName("altitude")
    val altitude: Int?,
    @SerializedName("reason")
    val reason: String?,
    @SerializedName("time")
    val time: Int?
)