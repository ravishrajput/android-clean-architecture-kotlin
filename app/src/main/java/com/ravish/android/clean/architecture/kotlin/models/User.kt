package com.ravish.android.clean.architecture.kotlin.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val username: String,
    var email: String,
    var imageUrl: String
): Parcelable