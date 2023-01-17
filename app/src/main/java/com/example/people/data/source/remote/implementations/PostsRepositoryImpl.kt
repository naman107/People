package com.example.people.data.source.remote.implementations

import com.example.people.data.model.Posts
import com.example.people.data.source.remote.api.IPeopleApiService
import com.example.people.data.source.repository.IPostsRepository
import com.example.people.general.DataState

class PostsRepositoryImpl: IPostsRepository {

    private val mIPeopleApiService = IPeopleApiService.createPeopleService()

    override suspend fun getPosts(): DataState<Posts> {
        val response = mIPeopleApiService.getAllPosts()
        return if(response.data.isNullOrEmpty()){
            DataState.Failure("No posts found!")
        }else{
            DataState.Success(response)
        }
    }

    override suspend fun getPost(id: String): DataState<Posts.Data> {
        val response = mIPeopleApiService.getPostById(id)
        return if(response == null){
            DataState.Failure("No post found!")
        }else{
            DataState.Success(response)
        }
    }

}