package com.example.people.data.source.remote.api

import com.example.people.data.model.Posts
import com.example.people.data.model.User
import com.example.people.data.model.Users
import com.example.people.data.utils.RetrofitManager
import retrofit2.http.GET
import retrofit2.http.Path

interface IPeopleApiService {

    companion object {
        private const val BASE_URL = "https://dummyapi.io/data/v1/"
        fun createPeopleService(): IPeopleApiService {
            return RetrofitManager.getRetrofitBuilder().baseUrl(BASE_URL).build().create(IPeopleApiService::class.java)
        }
    }

    @GET("user")
    fun getAllUsers(): Users

    @GET("user/:id")
    fun getUserById(@Path("id") id: String): User

    @GET("post")
    fun getAllPosts(): Posts

    @GET("user/:id")
    fun getPostById(@Path("id") id: String): Posts.Data
}