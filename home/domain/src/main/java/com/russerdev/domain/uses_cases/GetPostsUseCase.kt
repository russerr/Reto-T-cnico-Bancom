package com.russerdev.domain.uses_cases

import com.russerdev.domain.model.Post
import com.russerdev.domain.repository.HomeRepository

class GetPostsUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(): Result<List<Post>> {
        return repository.getPosts()
    }
}