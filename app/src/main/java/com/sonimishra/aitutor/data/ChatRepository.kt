package com.sonimishra.aitutor.data

import com.sonimishra.aitutor.api.ChatApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(val apiService: ChatApiService){

    suspend fun chatMessage(query:String): Flow<Message>{
        return flow{
            emit(apiService.chatQuery(query))
        }.map{
            it
        }
    }

}