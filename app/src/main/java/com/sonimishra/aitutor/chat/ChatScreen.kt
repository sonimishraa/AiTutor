@file:OptIn(ExperimentalMaterial3Api::class)

package com.sonimishra.aitutor.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sonimishra.aitutor.model.Message
import com.sonimishra.aitutor.model.QueryRequest
import com.sonimishra.aitutor.model.QueryResponse
import com.sonimishra.aitutor.model.SectionItem
import com.sonimishra.aitutor.model.Topic
import com.sonimishra.aitutor.utils.Loader
import com.sonimishra.aitutor.utils.NormalTextComponent
import com.sonimishra.aitutor.utils.UIState

@Composable
fun ChatScreen(topic: Topic, onBackClick:()-> Unit, viewModel: ChatScreenViewModel = hiltViewModel()) {
    val parts = topic.description.split(Regex(",\\s*|\\s+and\\s+"))
        .map { it.trim() }
    viewModel.sendMessageQuery(
        QueryRequest(
            subject = topic.title, level = topic.level,
            goal = "AI Learning", user_query = parts[0]
        )
    )
    val uiState by viewModel.chatMessage.collectAsStateWithLifecycle()
    var input by remember { mutableStateOf("") }
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "AI Tutor") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
    }, content = { padding ->
        Column(modifier = Modifier.padding(padding)) {
            when (uiState) {
                is UIState.Loading -> {
                    Loader()
                }

                is UIState.Error -> {
                    NormalTextComponent((uiState as UIState.Error<QueryResponse>).message)
                }

                is UIState.Success -> {
                    val data = (uiState as UIState.Success<QueryResponse>).data
                    ChatBubble(data)
                }
            }

           /* Row(
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

                    input = ""
                }) {
                    Text("Send")
                }
            }*/
        }
    })
}

@Composable
fun ChatBubble(queryRes: QueryResponse) {
    val response = parseResponse(queryRes)
    Scaffold() { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            items(response) { topic ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = topic.title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = topic.description)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

fun parseResponse(queryRes: QueryResponse): List<SectionItem> {
    val regex =
        Regex("(\\d+)\\.\\s*(.*?):\\n\\s*(.*?)(?=\\n\\n\\d+\\.|$)", RegexOption.DOT_MATCHES_ALL)

    return regex.findAll(queryRes.toString()).map { match ->
        val title = match.groupValues[2].trim()
        val description = match.groupValues[3].trim()
        SectionItem(
            title = title,
            description = description
        )
    }.toList()
}
