package com.example.people.data.model

data class Users(
    val data: List<Data>,
    val limit: Int,
    val page: Int,
    val total: Int
){
    data class Data(
        val firstName: String,
        val id: String,
        val lastName: String,
        val picture: String,
        val title: String
    )
}
