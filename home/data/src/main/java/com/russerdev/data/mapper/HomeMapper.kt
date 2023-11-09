package com.russerdev.data.mapper

import com.russerdev.data.remote.dto.PostDto
import com.russerdev.domain.model.Post

fun PostDto.toPost(): List<Post> {
    return posts.map { p ->
        Post(
            userId = p.userId,
            id = p.id,
            title = p.title,
            body = p.body
        )
    }
}