package com.ravish.android.clean.architecture.kotlin.mappers

import com.ravish.android.clean.architecture.domain.models.UserDetails
import com.ravish.android.clean.architecture.kotlin.models.User
import javax.inject.Inject

fun UserDetails.toUser() = User(id, name, username, email, imageUrl)