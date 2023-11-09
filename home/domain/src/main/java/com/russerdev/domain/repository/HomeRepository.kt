package com.russerdev.domain.repository

import com.russerdev.domain.model.Post

interface HomeRepository {

    suspend fun getPosts(): Result<List<Post>>
}