package com.yaritzama.spacex.di

import com.yaritzama.spacex.data.LaunchRepositoryImpl
import com.yaritzama.spacex.data.network.SpaceDataSource
import com.yaritzama.spacex.domain.LaunchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule
{
   @Provides
   @Singleton
   fun provideSpaceRepository(dataSource: SpaceDataSource): LaunchRepository = LaunchRepositoryImpl(dataSource)
}