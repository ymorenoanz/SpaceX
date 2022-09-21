package com.yaritzama.spacex.data.models


import com.google.gson.annotations.SerializedName

data class FirstStage(
    @SerializedName("cores")
    val cores: List<Core?>?
)