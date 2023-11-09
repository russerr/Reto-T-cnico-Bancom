package com.russerdev.data.repository

import com.russerdev.data.mapper.toPost
import com.russerdev.data.remote.HomeApi
import com.russerdev.domain.model.Post
import com.russerdev.domain.repository.HomeRepository

class HomeRepositoryImpl(private val apiService: HomeApi): HomeRepository {
    override suspend fun getPosts(): Result<List<Post>> {
        return try {
            val postsDto = apiService.getPosts()
            if (postsDto.isSuccessful) {
                postsDto.body()?.let {
                    Result.success(it.toPost())
                } ?: run {
                    Result.failure(Throwable("No Data"))
                }
            } else {
                Result.failure(Throwable("Response is not successful"))
            }
        } catch (e: Exception) {
            Result.failure(Throwable("Error General Exception"))
        }
    }
}