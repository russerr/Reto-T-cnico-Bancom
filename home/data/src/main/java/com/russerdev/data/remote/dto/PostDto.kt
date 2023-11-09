package com.russerdev.data.remote.dto

data class PostDto(
    val posts: List<Post>
)

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
