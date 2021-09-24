package com.ravish.android.clean.architecture.data.di

import com.ravish.android.clean.architecture.data.apis.UserApi
import com.ravish.android.clean.architecture.data.mappers.UserMapper
import com.ravish.android.clean.architecture.data.repo.UserInfoRepoImpl
import com.ravish.android.clean.architecture.domain.repositories.UserInfoRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserApiRepository(userApi: UserApi, userMapper: UserMapper): UserInfoRepo =
        UserInfoRepoImpl(userApi, userMapper)
}