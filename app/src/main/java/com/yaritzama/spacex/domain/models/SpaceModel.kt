package com.yaritzama.spacex.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpaceModel(
    val missionId: String = "",
    val missionName: String = "",
    val flightNumber: Int = 0,
    val launchDate: String = "",
    val launchSiteName: String = "",
    val rocketName: String = "",
    val linkImage: String? = null,
    var isSelected: Boolean = false
): Parcelable
