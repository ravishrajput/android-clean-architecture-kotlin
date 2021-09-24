package com.ravish.android.clean.architecture.domain.models

data class UserDetails(
    val id: Int,
    val name: String,
    val username: String,
    var email: String,
    var imageUrl: String
)