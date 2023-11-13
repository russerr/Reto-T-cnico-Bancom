package com.russerdev.domain.uses_cases

data class HomeUsesCases(
    val getPostUseCase: GetPostsUseCase,
    val createPostUseCase: CreatePostUseCase,
    val getSessionExpiredUseCase: GetSessionExpiredUseCase
)
