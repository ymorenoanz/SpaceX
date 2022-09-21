package com.yaritzama.spacex.data.models


import com.google.gson.annotations.SerializedName

data class Telemetry(
    @SerializedName("flight_club")
    val flightClub: String?
)