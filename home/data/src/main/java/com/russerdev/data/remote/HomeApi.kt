package com.russerdev.data.remote

import com.russerdev.data.remote.dto.Post
import com.russerdev.data.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeApi {

    @GET("users/1/posts")
    suspend fun getPosts(): Response<PostDto>

    @POST("posts")
    suspend fun createPost(): Response<Post>
}