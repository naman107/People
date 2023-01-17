package com.example.people.data.source.remote.implementations

import com.example.people.data.model.User
import com.example.people.data.model.Users
import com.example.people.data.source.remote.api.IPeopleApiService
import com.example.people.data.source.repository.IUsersRepository
import com.example.people.general.DataState

class UsersRepositoryImpl: IUsersRepository {

    private val mIPeopleApiService = IPeopleApiService.createPeopleService()

    override suspend fun getUsers(): DataState<Users> {
        val response = mIPeopleApiService.getAllUsers()
        return if(response.data.isNullOrEmpty()){
            DataState.Failure("No users found!")
        }else{
            DataState.Success(response)
        }
    }

    override suspend fun getUser(id: String): DataState<User> {
        val response = mIPeopleApiService.getUserById(id)
        return if(response == null){
            DataState.Failure("No user found!")
        }else{
            DataState.Success(response)
        }
    }

}