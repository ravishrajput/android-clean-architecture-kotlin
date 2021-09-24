package com.ravish.android.clean.architecture.data.models

data class UserDataModel(
    val id: Int,
    val name: String,
    val username: String,
    var email: String,
    var imageUrl: String
)