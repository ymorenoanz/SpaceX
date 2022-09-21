package com.yaritzama.spacex.data.network

import com.yaritzama.spacex.data.models.Spacex
import com.yaritzama.spacex.data.models.SpacexItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceXAPI
{
    @GET("launches")
    suspend fun getSpaceList(): Response<List<SpacexItem>>
}