package com.yaritzama.spacex.data.mappers

import com.yaritzama.spacex.data.models.Spacex
import com.yaritzama.spacex.data.models.SpacexItem
import com.yaritzama.spacex.domain.models.SpaceModel

fun SpacexItem.toDomain(): SpaceModel{
    return SpaceModel(
        missionId = missionId.toString(),
        missionName = missionName.toString(),
        launchDate = launchDateLocal.toString(),
        flightNumber = flightNumber?.toInt() ?: 0,
        launchSiteName = launchSite.toString(),
        rocketName = rocket?.rocketName.toString(),
        linkImage = links?.missionPatchSmall.toString()
    )
}