package com.yaritzama.spacex.data

import com.yaritzama.spacex.data.mappers.toDomain
import com.yaritzama.spacex.data.network.SpaceDataSource
import com.yaritzama.spacex.domain.LaunchRepository
import com.yaritzama.spacex.domain.helpers.ToDate
import com.yaritzama.spacex.domain.models.SpaceModel
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val remoteDataSource: SpaceDataSource
) : LaunchRepository
{
    override suspend fun fetchLaunchList(): List<SpaceModel> {
        //We transform data model to the response from the server
        val response = remoteDataSource.doFetchSpaceList()
        val list = response ?: emptyList()
        //It maps the data model to something useful that we define the domain model
        //DOMAIN MODEL
       return list.map {
           it.toDomain()
       }.sortedByDescending { it.launchDate.ToDate()}
    }

}