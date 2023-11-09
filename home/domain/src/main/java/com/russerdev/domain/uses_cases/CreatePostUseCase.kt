package com.russerdev.domain.uses_cases

import com.russerdev.domain.model.CreatePostRequest
import com.russerdev.domain.model.Post
import com.russerdev.domain.repository.HomeRepository

class CreatePostUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(request: CreatePostRequest): Result<Post> {
        return repository.createPost(request)
    }
}