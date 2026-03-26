package com.sonimishra.aitutor.chat

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import com.sonimishra.aitutor.data.Message
import com.sonimishra.aitutor.utils.AppBar
import com.sonimishra.aitutor.utils.ChatBubble
import com.sonimishra.aitutor.utils.Loader
import com.sonimishra.aitutor.utils.NormalTextComponent
import com.sonimishra.aitutor.utils.UIState

@Composable
fun ChatScreen(viewModel: ChatScreenViewModel = hiltViewModel() ) {
    val uiState by viewModel.chatMessage.collectAsStateWithLifecycle()
    var input by remember { mutableStateOf("") }
    Scaffold(topBar = {
        AppBar()
    }, content = { padding ->
        Column(modifier = Modifier.padding(padding)) {
            when (uiState) {
                is UIState.Loading -> {
                    Loader()
                }

                is UIState.Error -> {
                    NormalTextComponent((uiState as UIState.Error<Message>).message)
                }

                is UIState.Success -> {
                    val data = (uiState as UIState.Success<Message>).data
                    ChatBubble(data)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
                    .padding(8.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text(text = "Typing Message") }
                )

                Button(onClick = {
                    viewModel.sendMessageQuery(input)
                    input = ""
                }) {
                    Text("Send")
                }
            }
        }
    })
}