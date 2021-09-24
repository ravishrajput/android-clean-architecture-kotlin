package com.ravish.android.clean.architecture.data.di

import com.ravish.android.clean.architecture.data.apis.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {
    @Provides
    fun provideUserApiService(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}