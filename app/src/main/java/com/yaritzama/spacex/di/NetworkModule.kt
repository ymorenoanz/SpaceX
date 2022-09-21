package com.yaritzama.spacex.di

import com.squareup.picasso.BuildConfig
import com.yaritzama.spacex.data.network.SpaceXAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule
{
    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply{
        if(BuildConfig.DEBUG){
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
        }
    }.build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.spacexdata.com/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesSpaceAPI(retrofit: Retrofit) : SpaceXAPI = retrofit.create(SpaceXAPI::class.java)
}