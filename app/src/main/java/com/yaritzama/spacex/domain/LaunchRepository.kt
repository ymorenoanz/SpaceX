package com.yaritzama.spacex.domain

import com.yaritzama.spacex.domain.models.SpaceModel

interface LaunchRepository
{
    suspend fun fetchLaunchList(): List<SpaceModel>
    suspend fun getLaunchDetails(launch: SpaceModel): SpaceModel
}