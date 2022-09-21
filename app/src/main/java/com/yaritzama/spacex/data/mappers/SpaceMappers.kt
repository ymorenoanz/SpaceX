package com.yaritzama.spacex.data.mappers

import com.yaritzama.spacex.data.models.Spacex
import com.yaritzama.spacex.data.models.SpacexItem
import com.yaritzama.spacex.domain.models.SpaceModel

fun SpacexItem.toDomain(): SpaceModel{
    return SpaceModel(
        missionId = missionId.toString(),
        missionName = missionName?:"",
        launchDate = launchDateUtc?:"",
        flightNumber = flightNumber?: 0,
        launchSiteName = launchSite?.siteName?:"",
        rocketName = rocket?.rocketName?:"",
        linkImage = links?.missionPatchSmall
    )
}