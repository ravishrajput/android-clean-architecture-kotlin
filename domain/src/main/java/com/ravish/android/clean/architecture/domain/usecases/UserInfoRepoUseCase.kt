package com.ravish.android.clean.architecture.domain.usecases

import com.ravish.android.clean.architecture.domain.models.UserDetails
import com.ravish.android.clean.architecture.domain.repositories.UserInfoRepo
import javax.inject.Inject

open class UserInfoRepoUseCase @Inject constructor(private val repo: UserInfoRepo) {
    suspend fun getUsersList(): List<UserDetails> = repo.getUsersList()
    suspend fun getUserInfo(id: String): UserDetails = repo.getUserInfo(id)
}