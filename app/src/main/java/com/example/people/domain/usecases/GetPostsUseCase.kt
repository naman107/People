package com.example.people.domain.usecases

import com.example.people.data.model.Posts
import com.example.people.data.source.remote.implementations.PostsRepositoryImpl
import com.example.people.domain.implementations.IGetPostsUseCase
import com.example.people.general.DataState

class GetPostsUseCase: IGetPostsUseCase {

    override suspend fun getPost(): DataState<Posts> {
        return PostsRepositoryImpl().getPosts()
    }

    override suspend fun getPost(id: String): DataState<Posts.Data> {
        return PostsRepositoryImpl().getPost(id)
    }

}