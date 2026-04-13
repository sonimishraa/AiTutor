package com.sonimishra.aitutor.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonimishra.aitutor.data.ChatRepository
import com.sonimishra.aitutor.model.Message
import com.sonimishra.aitutor.model.QueryRequest
import com.sonimishra.aitutor.model.QueryResponse
import com.sonimishra.aitutor.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatScreenViewModel @Inject constructor(val repository: ChatRepository): ViewModel() {

    private val _chatMessage = MutableStateFlow<UIState<QueryResponse>>(UIState.Loading)
    val chatMessage:MutableStateFlow<UIState<QueryResponse>> = _chatMessage

    fun sendMessageQuery(query: QueryRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.chatMessage(query)
                .catch { e ->
                    Log.d("ViewmOdelChat", e.message.toString())
                    _chatMessage.value = UIState.Error(e.message.toString())
                }.collect {
                    Log.d("ViewmOdelChat", it.toString())
                    _chatMessage.value = UIState.Success(it)
                }
        }
    }
}