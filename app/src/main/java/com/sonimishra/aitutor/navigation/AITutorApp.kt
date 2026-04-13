package com.sonimishra.aitutor.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sonimishra.aitutor.chat.ChatScreen
import com.sonimishra.aitutor.model.Topic
import com.sonimishra.aitutor.uis.TopicDetailsScreen
import com.sonimishra.aitutor.uis.TopicsScreen


@Composable
fun AITutorApp() {
    val navController = rememberNavController()
    val topicList: List<Topic> = listOf(
        Topic(1, "Machine Learning", "Learn regression, classification, and model evaluation.", "Beginner"),
        Topic(2, "Deep Learning", "Neural networks, CNNs, RNNs, and transformers.", "Intermediate"),
        Topic(3, "NLP", "Text processing, embeddings, and LLM basics.", "Intermediate"),
        Topic(4, "Computer Vision", "Image classification and object detection.", "Intermediate"),
        Topic(5, "Reinforcement Learning", "Agents, rewards, and policy optimization.", "Advanced"),
        Topic(6, "LLM Systems", "RAG, vector DB, prompting, and agent workflows.", "Advanced")
    )


    NavHost(navController = navController, startDestination = "topics") {
        composable("topics") {
            TopicsScreen(
                topics = topicList,
                onTopicClick = { topicId ->
                    navController.navigate("details/$topicId")
                },
            )
        }

        composable(
            route = "details/{topicId}",
            arguments = listOf(navArgument("topicId") { type = NavType.IntType })
        ) { backStackEntry ->
            val topicId = backStackEntry.arguments?.getInt("topicId") ?: 1
            val topic = topicList.first { it.id == topicId }
            TopicDetailsScreen(
                topic, onBackClick = {
                    navController.popBackStack()
                },
                onStartClick = { topicId ->
                    navController.navigate("chatScreen/$topicId")
                }
            )
        }
        composable(
            route = "chatScreen/{topicId}",
            arguments = listOf(navArgument("topicId") { type = NavType.IntType })
        ) { backStackEntry ->
            val topicId = backStackEntry.arguments?.getInt("topicId") ?: 1
            val topic = topicList.first { it.id == topicId }
            ChatScreen(
                topic = topic,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
