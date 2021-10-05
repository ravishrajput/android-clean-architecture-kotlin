package com.ravish.android.clean.architecture.kotlin.mappers

import com.ravish.android.clean.architecture.domain.models.UserDetails
import com.ravish.android.clean.architecture.kotlin.models.User
import javax.inject.Inject

class UserMapper @Inject constructor() {
    fun toUserDetails(userDataModel: UserDetails): User = User(
        userDataModel.id,
        userDataModel.name,
        userDataModel.username,
        userDataModel.email,
        userDataModel.imageUrl
    )
}