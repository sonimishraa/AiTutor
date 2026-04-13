package com.sonimishra.aitutor.api

import com.sonimishra.aitutor.model.Message
import com.sonimishra.aitutor.model.QueryRequest
import com.sonimishra.aitutor.model.QueryResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface ChatApiService {
    @POST("ask")
    suspend fun chatQuery(@Body request: QueryRequest): QueryResponse
}