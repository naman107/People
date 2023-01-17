package com.example.people.domain.implementations

import com.example.people.data.model.User
import com.example.people.data.model.Users
import com.example.people.general.DataState

interface IGetUsersUseCase {
    suspend fun getUsers(): DataState<Users>
    suspend fun getUser(id: String): DataState<User>
}