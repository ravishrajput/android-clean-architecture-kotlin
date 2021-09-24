package com.ravish.android.clean.architecture.data.mappers

import com.ravish.android.clean.architecture.data.models.UserDataModel
import com.ravish.android.clean.architecture.domain.models.UserDetails

class UserMapper {
    fun toUserDetails(userDataModel: UserDataModel): UserDetails = UserDetails(
        userDataModel.id,
        userDataModel.name,
        userDataModel.username,
        userDataModel.email,
        userDataModel.imageUrl
    )
}