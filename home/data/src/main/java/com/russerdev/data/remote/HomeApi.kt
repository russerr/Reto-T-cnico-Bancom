package com.russerdev.data.remote

import com.russerdev.data.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {

    @GET("users/1/posts")
    suspend fun getPosts(): Response<PostDto>
}