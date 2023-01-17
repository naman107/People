package com.example.people.data.source.repository

import com.example.people.data.model.Posts
import com.example.people.general.DataState

interface IPostsRepository {
    suspend fun getPosts(): DataState<Posts>
    suspend fun getPost(id: String): DataState<Posts.Data>
}