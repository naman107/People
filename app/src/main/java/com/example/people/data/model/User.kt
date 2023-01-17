package com.example.people.data.model

data class User(
    val dateOfBirth: String,
    val email: String,
    val firstName: String,
    val gender: String,
    val id: String,
    val lastName: String,
    val location: Location,
    val phone: String,
    val picture: String,
    val registerDate: String,
    val title: String,
    val updatedDate: String
){
    data class Location(
        val city: String,
        val country: String,
        val state: String,
        val street: String,
        val timezone: String
    )
}
