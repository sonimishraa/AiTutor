package com.sonimishra.aitutor.api

import com.sonimishra.aitutor.data.Message
import retrofit2.http.POST
import retrofit2.http.Query

interface ChatApiService {
    @POST("chat")
    suspend fun chatQuery(@Query("query")query:String): Message
}