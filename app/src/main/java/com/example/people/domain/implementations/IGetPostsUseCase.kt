package com.example.people.domain.implementations

import com.example.people.data.model.Posts
import com.example.people.general.DataState

interface IGetPostsUseCase {
    suspend fun getPost(): DataState<Posts>
    suspend fun getPost(id: String): DataState<Posts.Data>
}