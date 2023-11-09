package com.russerdev.domain.repository

import com.russerdev.domain.model.CreatePostRequest
import com.russerdev.domain.model.Post

interface HomeRepository {

    suspend fun getPosts(): Result<List<Post>>

    suspend fun createPost(request: CreatePostRequest): Result<Post>
}