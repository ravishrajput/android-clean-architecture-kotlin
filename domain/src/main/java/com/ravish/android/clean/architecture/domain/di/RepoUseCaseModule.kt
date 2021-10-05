package com.ravish.android.clean.architecture.domain.di

import com.ravish.android.clean.architecture.domain.repositories.UserInfoRepo
import com.ravish.android.clean.architecture.domain.usecases.UserInfoRepoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepoUseCaseModule {
    @Provides
    fun provideUserInfoUseCase(repo: UserInfoRepo): UserInfoRepoUseCase = UserInfoRepoUseCase(repo)
}