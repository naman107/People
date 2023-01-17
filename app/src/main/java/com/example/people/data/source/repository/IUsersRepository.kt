package com.example.people.data.source.repository

import com.example.people.data.model.User
import com.example.people.data.model.Users
import com.example.people.general.DataState

interface IUsersRepository {
    suspend fun getUsers(): DataState<Users>
    suspend fun getUser(id: String): DataState<User>
}