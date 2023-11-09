package com.russerdev.domain.model

data class CreatePostRequest(
    val title: String,
    val body: String,
    val userId: Int
)
