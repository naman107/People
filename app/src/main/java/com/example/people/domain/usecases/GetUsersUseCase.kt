package com.example.people.domain.usecases

import com.example.people.data.model.User
import com.example.people.data.model.Users
import com.example.people.data.source.remote.implementations.UsersRepositoryImpl
import com.example.people.domain.implementations.IGetUsersUseCase
import com.example.people.general.DataState

class GetUsersUseCase: IGetUsersUseCase {

    override suspend fun getUsers(): DataState<Users> {
        return UsersRepositoryImpl().getUsers()
    }

    override suspend fun getUser(id: String): DataState<User> {
        return UsersRepositoryImpl().getUser(id)
    }

}