package com.yaritzama.spacex.data.network

import com.yaritzama.spacex.data.models.Spacex
import com.yaritzama.spacex.data.models.SpacexItem
import javax.inject.Inject

class SpaceDataSource @Inject constructor(
    private val api: SpaceXAPI
) {
    suspend fun doFetchSpaceList(): List<SpacexItem>?{
        return try{
            val response =
                api.getSpaceList()
            if(response.isSuccessful){
                response.body()
            }
            else{
                null
            }
        }catch(e: Exception){
            null
        }
    }

  }