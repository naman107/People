package com.example.people.general

sealed class DataState<out T> {
    data class Success<out T>(val t: T): DataState<T>()
    data class Failure(val error: String): DataState<Nothing>()
}

