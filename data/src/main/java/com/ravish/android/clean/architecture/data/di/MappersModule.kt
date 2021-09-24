package com.ravish.android.clean.architecture.data.di

import com.ravish.android.clean.architecture.data.mappers.UserMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MappersModule {
    @Provides
    @Singleton
    fun provideUserMapper(): UserMapper = UserMapper()
}