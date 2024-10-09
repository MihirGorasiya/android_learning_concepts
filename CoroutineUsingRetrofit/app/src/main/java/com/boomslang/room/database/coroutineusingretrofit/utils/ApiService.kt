package com.boomslang.room.database.coroutineusingretrofit.utils

import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}