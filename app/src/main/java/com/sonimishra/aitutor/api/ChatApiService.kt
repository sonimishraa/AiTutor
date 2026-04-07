package com.sonimishra.aitutor.api

import com.sonimishra.aitutor.data.Message
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface ChatApiService {
    @FormUrlEncoded
    @POST("chat")
    suspend fun chatQuery(@Field("query")query:String): Message
}