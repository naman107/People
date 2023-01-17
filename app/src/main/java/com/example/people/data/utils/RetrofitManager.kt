package com.example.people.data.utils

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    fun getRetrofitBuilder(): Retrofit.Builder {

        val loggerInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(100,TimeUnit.SECONDS)
            .readTimeout(100,TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor())
            .addInterceptor(loggerInterceptor)
            .build()

        return Retrofit.Builder()
            .client(clientBuilder)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }

    internal class AuthInterceptor: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
            request.addHeader(APP_ID, HEADER_APP_ID)
            return chain.proceed(request.build())
        }

    }

}